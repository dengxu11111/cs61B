public class Planet{
	static double G=6.67e-11;
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public String image="./images/";
	public Planet(double xP,double yP,double xV,double yV,double m,String img){
		this.xxPos=xP;
		this.yyPos=yP;
		this.xxVel=xV;
		this.yyVel=yV;
		this.mass=m;
		this.imgFileName=img;
	}
	public Planet(Planet p){
		this.xxPos=p.xxPos;
		this.yyPos=p.yyPos;
		this.xxVel=p.xxVel;
		this.yyVel=p.yyVel;
		this.mass=p.mass;
		this.imgFileName=p.imgFileName;
	}
	public double calcDistance(Planet p1){
		double dx=this.xxPos-p1.xxPos;
		double dy=this.yyPos-p1.yyPos;
		return Math.pow(Math.pow(dx,2)+Math.pow(dy,2),0.5);
	}
	public double calcForceExertedBy(Planet p1){
		return Planet.G*this.mass*p1.mass/Math.pow(this.calcDistance(p1),2);
	}
	public double calcForceExertedByX(Planet p1){
		return this.calcForceExertedBy(p1)*(p1.xxPos-this.xxPos)/this.calcDistance(p1);
	}

	public double calcForceExertedByY(Planet p1){
		return this.calcForceExertedBy(p1)*(p1.yyPos-this.yyPos)/this.calcDistance(p1);
	}
	public double calcNetForceExertedByX(Planet[] planets){
		double sum=0;
		for(Planet planet:planets){
			if(this!=planet)
			sum+=this.calcForceExertedByX(planet);
		}
		return sum;
	}
	public double calcNetForceExertedByY(Planet[] planets){
		double sum=0;
		for(Planet planet:planets){
			if(this!=planet)
			sum+=this.calcForceExertedByY(planet);
		}
		return sum;
	}
	public void update(double dt,double fx,double fy){
		double ax=fx/mass;
		double ay=fy/mass;
		xxVel=xxVel+ax*dt;
		yyVel=yyVel+ay*dt;
		xxPos=xxPos+xxVel*dt;
		yyPos=yyPos+yyVel*dt;
	}
	public void draw(){
		StdDraw.picture(xxPos,yyPos,image.concat(imgFileName));
	
	
	
	}

}
