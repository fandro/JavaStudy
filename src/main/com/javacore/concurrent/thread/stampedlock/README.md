
===

LinkedTransferQueueFix.java: 这是为JDK中的LinkedTransferQueue增加了补丁之后的文件，修正了因节点的取消而丧失信号的问题。

StampedLock.java：这是为JDK中的StampedLock增加了保存/恢复中断机制之后的文件，修正了原来的CPU占有问题，如果要测试，请注意其中使用的LockSupport.nextSecondarySeed等方法是包控制域。

============
Bug:StampedLock的中断问题导致CPU爆满

StampedLock作为JAVA8中出现的新型锁，很可能在大多数场景都可以替代ReentrantReadWriteLock。它对于读/写都提供了四个接口(换成write为写锁)：

    readLock()
    tryReadLock()
    tryReadLock(long time, TimeUnit unit)
    readLockInterruptibly()

这几个方法对应的语义为：

    获取读锁（阻塞，不响应中断）
    获取读锁（立即）
    限时获取读锁（响应中断）
    获取读锁（阻塞，响应中断）

然而在readLock方法（即不响应中断）中存在问题(write的版本也是)，观察CPU使用率，执行以下代码：
01	public class TestStampedLock {
02	    public static void main(String[] args) throws InterruptedException{
03	    final StampedLock lock = new StampedLock();
04	    new Thread(){
05	       public void run(){
06	       long readLong = lock.writeLock();
07	       LockSupport.parkNanos(6100000000L);
08	       lock.unlockWrite(readLong);
09	     }
10	    }.start();
11	    Thread.sleep(100);
12	    for( int i = 0; i < 3; ++i)
13	       new Thread(new OccupiedCPUReadThread(lock)).start();
14	    }
15	    private static class OccupiedCPUReadThread implements Runnable{
16	        private StampedLock lock;
17	        public OccupiedCPUReadThread(StampedLock lock){
18	            this.lock = lock;
19	        }
20	        public void run(){
21	            Thread.currentThread().interrupt();
22	            long lockr = lock.readLock();
23	            System.out.println(Thread.currentThread().getName() + " get read lock");
24	            lock.unlockRead(lockr);
25	        }
26	    }
27	}
先开启一个线程获取写锁并保持6秒，再开启三个带着中断状态的线程去获取读锁（readLock方法），结果是3个核心被占据了近6秒。
原因在于没有使用保存/复原中断状态的机制，通过hack源码，插入保存中断和返回前恢复中断的相关代码即可修复：
1	boolean interrupted = false;
1	if(interrupted)
2	    Thread.currentThread().interrupt();
3	return ns;
1	if(Thread.interrupted()){
2	    if(interruptible)
3	        return cancelWaiter(node, p, true);
4	    else
5	        interrupted = true;
6	}
StampedLock

（全文完）如果您喜欢此文请点赞，分享，评论。 