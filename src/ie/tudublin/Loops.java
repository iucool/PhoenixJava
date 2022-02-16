package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{


	int mode = 0;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		
	}

	public void keyPressed()
	{
		if (key >= '0' && key <='9')
		{
			mode = key - '0';
		}
		println(mode);
	}

	float magicMap(float a, float b, float c, float d, float e)
	{
		float output;
		a -= b;
		c -= b;
		e-= d;

		output = ((a/c)*e) + d;

		return output;
	}

	float magicMap1(float a, float b, float c, float d, float e)
	{
		float r1 = c -b;
		float r2 = e-d;
		float howFar = a - b;

		return d + ((howFar / r1) * r2);
	}

	
	public void draw()
	{
		float offset = 0;
		
		switch(mode)	
		{
			case 0:
			{
				background(0);
				int bars = (int) (mouseX / 20.0f);
				float w = width / (float)bars;	
				for(int i = 0 ; i < bars ; i ++)
				{
					noStroke();
					fill(map(i, 0, bars, 0, 255), 255, 255);
					rect(map(i, 0, bars, 0, 500), 0, w, height);
				}
				break;
			}
			case 1:
			{
			int squares = (int) (mouseX / 20.0f);
			float h = width / (float) squares;
			for(int i = 0 ; i < squares ; i ++)
			{
				noStroke();
				fill(map(i , 0, squares, 0, 255), 255, 255);
				float x = map(i, 0, squares, 0, width);
				rect(x, x, h, h);
				rect((width -h) -x, x, h, h);
			}
		}
			case 2:
			{
			int numCircles  = (int) (20 * (mouseX / (float) width)) ;
		
		float n = width / (float) numCircles;
		float radius = n / 2.0f;
		colorMode(HSB);
		float cGap = 255 / (float) (numCircles * numCircles);
		noStroke();

		for(int j = 0 ; j < numCircles ; j ++)
		{		
			for(int i = 0 ; i < numCircles ; i ++)
			{
				float x = radius + (i * n);
				float y = radius + (j * n);
				float c = (cGap * i * j + offset) % 255; 
				fill(c, 255, 255);
				ellipse(x, y, n, n);
			}
		}
		offset += mouseY / 250.0f;
				break;
	}
		    case 3:
			{
			float gap = width * 0.1f;
		float halfGap = gap / 2.0f;
		colorMode(RGB);
		stroke(0, 255, 0);
		textAlign(CENTER, CENTER);
		for(int i = -5 ; i <=5 ; i ++)
		{
			float x = map(i, -5, 5, gap, width -gap);				
			line(x, gap, x, height - gap);
			line(gap, x, width - gap, x);
			fill(255);
			text(i, x, halfGap);
			text(i, halfGap, x);
		}
		}
		case 4:
		{
			background(0);
			int circles = (int) (mouseX / 20.f);
			offset += mouseY;
			float d = width / (float)circles;
			for(int j = 0 ; j < circles ; j++)
			{
			
			for(int i = 0 ; i < circles ; i++)
			{
				noStroke();
				float c = map((i + j+ offset), 0, circles * 2, 0, 255) % 256;
				fill(c, 255, 255);
				float x = map(i, 0, circles - 1, d / 2.0f, width - (d / 2.0f));
				float y = map(i, 0, circles - 1, d / 2.0f, width - (d / 2.0f));
				circle(map(i, 0, circles - 1, d / 2.0f, width - (d / 2.0f)), height / 2, d);
				circle(x, y, d);
			}
		}
	}
	

				//map(a,b,c,d,e);
				//a = inputvalue
				// b - c - start and end of the first range
				// d, e 0 - start and and of the end range

				// map(-2, 10, 90, 200, 233);

		}
	}
}
