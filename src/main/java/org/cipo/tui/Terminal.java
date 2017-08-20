package org.cipo.tui;

import com.google.inject.Singleton;

@Singleton
public class Terminal implements ITerminal {
	private char escCode = 0x1B;

	

	private String ESC(String str) {
		return String.format("%c[%s",this.escCode,str);
	}
	
	private void printEsc(String... str) {

		String jstr =  String.join("", str);
		System.out.print(this.ESC(jstr));
	}
	 private void attr(String... att) {
	    
		String attrs =  String.join(";", att);
		this.printEsc(attrs,"m");
		
	 }

	
	@Override
	public void clear() {
		
		this.printEsc("2J");
		
	}
	

	@Override
	public void gotoxy(int x, int y) {
		this.printEsc(String.format("%d;%df",x,y));
	}

	@Override
	public void color(String color) {
		// TODO Auto-generated method stub
		String clr = color.toUpperCase();
		/*
		 * 30	Black
31	Red
32	Green
33	Yellow
34	Blue
35	Magenta
36	Cyan
37	White
		 * */
		if(clr=="BLACK") {
			this.attr("30");
		}else if (clr=="RED") {
			this.attr("31");
		}else if (clr=="GREEN") {
			this.attr("32");
		}else if (clr=="YELLOW") {
			this.attr("33");
		}else if (clr=="BLUE") {
			this.attr("34");
		}else if (clr=="MAGENTA") {
			this.attr("35");
		}else if (clr=="CYAN") {
			this.attr("36");
		}else if (clr=="WHITE") {
			this.attr("37");			
		}
		
	}

	@Override
	public void bgcolor(String color) {
		/**
		 * 40	Black
41	Red
42	Green
43	Yellow
44	Blue
45	Magenta
46	Cyan
47	White
		 */
		String clr = color.toUpperCase();
		if(clr=="BLACK") {
			this.attr("40");
		}else if (clr=="RED") {
			this.attr("41");
		}else if (clr=="GREEN") {
			this.attr("42");
		}else if (clr=="YELLOW") {
			this.attr("43");
		}else if (clr=="BLUE") {
			this.attr("44");
		}else if (clr=="MAGENTA") {
			this.attr("45");
		}else if (clr=="CYAN") {
			this.attr("46");
		}else if (clr=="WHITE") {
			this.attr("47");			
		}
		
		
	}

	@Override
	public void reset() {
		this.attr("0");
	}

	@Override
	public void print(Object... obj) {
		
		for (Object object : obj) {
			System.out.print(object);		
		}
		
	}
	@Override
	public void println(Object... obj) {
		
		for (Object object : obj) {
			System.out.print(object);		
		}
		
		System.out.println();
		
	}

	@Override
	public void info(Object... obj) {
		// TODO Auto-generated method stub
		this.color(ITerminal.GREEN);
		for (Object object : obj) {
			this.print(object);		
		}
		
		
	}

	@Override
	public void infoln(Object... obj) {
		this.color(ITerminal.GREEN);
		for (Object object : obj) {
			this.print(object);		
		}
		this.println();

		
	}

	@Override
	public void warning(Object... obj) {
		this.color(ITerminal.YELLOW);
		for (Object object : obj) {
			this.print(object);		
		}
		
		
	}

	@Override
	public void warningln(Object... obj) {
		this.color(ITerminal.YELLOW);
		for (Object object : obj) {
			this.print(object);		
		}
		this.println();
		
	}

	@Override
	public void error(Object... obj) {
		this.color(ITerminal.RED);
		for (Object object : obj) {
			this.print(object);		
		}
	
		
	}

	@Override
	public void errorln(Object... obj) {
		this.color(ITerminal.RED);
		for (Object object : obj) {
			this.print(object);		
		}
		this.println();
		
	}

	@Override
	public void comment(Object... obj) {
		this.color(ITerminal.BLUE);
		for (Object object : obj) {
			this.print(object);		
		}
		
	}

	@Override
	public void commentln(Object... obj) {
		this.color(ITerminal.BLUE);
		for (Object object : obj) {
			this.print(object);		
		}
		this.println();
		
	}
	
}
