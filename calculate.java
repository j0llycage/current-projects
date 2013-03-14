import java.io.*;
import java.util.*;
import java.math.*;


public class calculate {
  
	static float spokeHoleDiameter; //variable to hold the spoke hole diameter
	static float spokeHoleRadius; //variable to hold the spoke hole radius
	static float flangeDiameter;
	static float flangeRadius;
	static float flangeOffset;
	static float eRD;
	static float rimRadius;
	static float numCrosses;
	static float numSpokes;
	static double spokeLength;
	
	
		public static float getSpokeHoleDiameter()
		{
			System.out.println("Enter the Spoke Hole Diameter: \n");
			Scanner hHDI = new Scanner(System.in);
			spokeHoleDiameter = hHDI.nextFloat();
			spokeHoleRadius = spokeHoleDiameter/2;
			if(spokeHoleRadius <= 0)
			{
				System.out.println("Invalid diameter value. Spoke hole diameter must be greater than 0.\n");
				getSpokeHoleDiameter();
			}
			return spokeHoleRadius;
		}
		
		public static float getFlangeDiameter()
		{
			System.out.println("Enter the Flange Diameter: \n");
			Scanner hFDI = new Scanner(System.in);
			flangeDiameter = hFDI.nextInt();
			flangeRadius = flangeDiameter/2;
			if(flangeRadius <= 0)
			{
				System.out.println("Invalid diameter value. Flange diameter must be greater than 0.\n");
				getFlangeDiameter();
			}
			return flangeRadius;
		}

		public static float getFlangeOffset()
		{
			System.out.println("Enter the distance from the center of the hub to the flange: \n");
			Scanner hFOI = new Scanner(System.in);
			flangeOffset = hFOI.nextInt();
			if(flangeOffset <= 0)
			{
				System.out.println("Invalid offset value. Flange offset must be greater than 0.\n");
				getFlangeOffset();
			}
			return flangeOffset;
		}
		
		public static float getRimDiameter()
		{
			System.out.println("Enter the Effective Rim Diameter: \n");
			Scanner rDI = new Scanner(System.in);
			eRD = rDI.nextInt();
			rimRadius = eRD/2;
			if(rimRadius <= 0)
			{
				System.out.println("Invalid diameter value. Rim diameter must be greater than 0.\n");
				getRimDiameter();
			}
			return rimRadius;
		}
		
		public static float getNumCrosses()
		{
			System.out.println("Enter the number of Spoke Crosses: \n");
			Scanner nCI = new Scanner(System.in);
			numCrosses = nCI.nextInt();
			if(numCrosses < 0)
			{
				System.out.println("Invalid number of crosses. Spoke crosses cannot be negative.\n");
				getNumCrosses();
			}
			return numCrosses;
		}
		
		public static float getNumSpokes()
		{
			System.out.println("Enter the number of Spokes: \n");
			Scanner nSI = new Scanner(System.in);
			numSpokes = nSI.nextInt();
			if(numSpokes <= 0)
			{
				System.out.println("Invalid number of spokes. Number of spokes must be greater than 0.\n");
				getNumSpokes();
			}
			return numSpokes;
		}
		
		public static void calculateSpokeLength()
		{
			spokeLength = Math.sqrt(((rimRadius * rimRadius) + (flangeRadius * flangeRadius) + (flangeOffset * flangeOffset)) -(2*(rimRadius)*(flangeRadius)*Math.cos((720 * Math.PI * numCrosses)/(180 * numSpokes)))) - (spokeHoleRadius);
			spokeLength = Math.round(spokeLength * 100.0) / 100.0;
			System.out.println("Spoke length: " + spokeLength);
		}

		public static void main(String[] args)
		{
			getSpokeHoleDiameter();
			getFlangeDiameter();
			getFlangeOffset();
			getRimDiameter();
			getNumCrosses();
			getNumSpokes();
			calculateSpokeLength();
		}
	
}
