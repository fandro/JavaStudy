package com.algorithm.$4_charsearch;

/**
 * 字典树 Trie.
 *
 * @author fuwb
 * @since 2021-03-05
 */
public class Trie {

    // 存储无意义的字符
    private TrieNode root = new TrieNode('/');

    /**
     * 往Trie中插入字符串.
     * @param text
     */
    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    /**
     * 在Trie树中查找字符串.
     * @param pattern
     * @return
     */
    public boolean find(char[] pattern) {
        TrieNode p = root;
        for (int i = 0; i < pattern.length ; i++) {
            int index = pattern[i] - 'a';
            if (p.children[i] == null) {
                // 不存在
                return false;
            }
            p = p.children[index];
        }

        if (!p.isEndingChar) {
            // 不能完全匹配，只是前缀
            return false;
        } else {
            return true;
        }
    }

    public class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data =data;
        }
    }

}
