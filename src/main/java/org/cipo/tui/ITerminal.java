package org.cipo.tui;

public interface ITerminal {

	public static final String RED = "RED";
	public static final String BLACK = "BLACK";
	public static final String GREEN = "GREEN";
	public static final String YELLOW = "YELLOW";
	public static final String BLUE = "BLUE";
	public static final String MAGENTA = "MANGENTA";
	public static final String CYAN = "CYAN";
	public static final String WHITE = "WHITE";
	
	/*
	Black
	31	Red
	32	Green
	33	Yellow
	34	Blue
	35	Magenta
	36	Cyan
	37	White
	*/
	public void clear();
	public void gotoxy(int x, int y);
	public void color(String color);
	public void bgcolor(String color);
	public void reset();
	
	public void print(Object... obj);
	public void println(Object... obj);
	public void info(Object... obj);
	public void infoln(Object... obj);
	public void warning(Object... obj);
	public void warningln(Object... obj);
	public void error(Object... obj);
	public void errorln(Object... obj);
	public void comment(Object... obj);
	public void commentln(Object... obj);
	
	 
	
}
