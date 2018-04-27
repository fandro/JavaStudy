package designpattern.creationalpattern.builder;


public abstract class Builder {

		
		/**
		 */
		public abstract void BuildDoor();

			
		/**
		 */
		public abstract void BuildWall();


				
		/**
		 */
		public abstract void BuildWindows();


		
		/**
		 */
		public abstract void BuildHouseCeiling();


		
		/**
		 * @return 
		 */
		public abstract House GetHouse();
		
					
				
			
		

}
