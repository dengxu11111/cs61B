public class NBody{
	static int numbers;
	static double radius;

	public static double readRadius(String planetsTxtPath){
		In in=new In(planetsTxtPath);
		int i=in.readInt();
		double d=in.readDouble();
		return d;
	}
	public  static Planet[] readPlanets(String planetsTxtPath){
		In in=new In(planetsTxtPath);
		numbers=in.readInt();
		radius=in.readDouble();
		Planet[] p=new Planet[numbers];
		for(int i=0;i<numbers;i++){
			double xxPos=in.readDouble();
			double yyPos=in.readDouble();
			double xxVel=in.readDouble();
			double yyVel=in.readDouble();
			double mass=in.readDouble();
			String name=in.readString();
			p[i]=new Planet(xxPos,yyPos,xxVel,yyVel,mass,name);
		
		}
		return p;
	}
	public static void main(String[] args){
		StdDraw.enableDoubleBuffering();
		double T= Double.parseDouble(args[0]);
		double dt= Double.parseDouble(args[1]);
		double t=0;
		String filename=args[2];
		Planet[] p=readPlanets(filename);
		System.out.println(p[1].mass);
		StdDraw.setScale(-radius,radius);
		while(t<T){
			double[] xForces=new double[numbers];
			double[] yForces=new double[numbers];
			for(int i=0;i<numbers;i++){
				xForces[i]=p[i].calcNetForceExertedByX(p);
				yForces[i]=p[i].calcNetForceExertedByY(p);
		
		}
			for(int i=0;i<numbers;i++){
				p[i].update(dt,xForces[i],yForces[i]);
			
			}
			StdDraw.picture(0,0,"./images/starfield.jpg",2*radius,2*radius);
			for(Planet p1:p){
				p1.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			t+=dt;
		}
	}

}

	
