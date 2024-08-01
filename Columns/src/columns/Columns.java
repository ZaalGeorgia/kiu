package columns;
import java.applet.*;
import java.awt.*;
import java.util.*;


public class Columns extends Applet implements Runnable {
    static final int
    SL=25,
    Depth=15,
    Width=7,
    MaxLevel=7,
    TimeShift=250,
    FigToDrop=33,
    MinTimeShift=200,
    LeftBorder=2,
    TopBorder=2;
    
    
    Color MyStyles[] = {Color.black,Color.cyan,Color.blue,Color.red,Color.green,
    Color.yellow,Color.pink,Color.magenta,Color.black};
    
    int Level, j, ii, removedCellsCounter, ch;
    long Score, DropScore, tc;
    Font fCourier;
    Figure Fig;
    int Fnew[][],Fold[][];
    boolean NoChanges = true, KeyPressed = false;
    Graphics _gr;
    
    Thread thr = null;
    
    
    void CheckNeighbours(int a, int b, int c, int d, int i, int j) {
        if ((Fnew[j][i]==Fnew[a][b]) && (Fnew[j][i]==Fnew[c][d])) {
            Fold[a][b] = 0;
            DrawBox(a,b,8);
            Fold[j][i] = 0;
            DrawBox(j,i,8);
            Fold[c][d] = 0;
            DrawBox(c,d,8);
            NoChanges = false;
            Score += (Level+1)*10;
            removedCellsCounter++;
        };
    }
    void Delay(long t) {
        try {
            Thread.sleep(t);
        }
        catch (InterruptedException e) {};
    }
    void DrawBox(int x, int y, int c) {
        if (c==0) {
            _gr.setColor(Color.black);
            _gr.fillRect(LeftBorder+x*SL-SL, TopBorder+y*SL-SL, SL, SL);
            _gr.drawRect(LeftBorder+x*SL-SL, TopBorder+y*SL-SL, SL, SL);
        }
        else if (c==8) {
            _gr.setColor(Color.white);
            _gr.drawRect(LeftBorder+x*SL-SL+1, TopBorder+y*SL-SL+1, SL-2, SL-2);
            _gr.drawRect(LeftBorder+x*SL-SL+2, TopBorder+y*SL-SL+2, SL-4, SL-4);
            _gr.setColor(Color.black);
            _gr.fillRect(LeftBorder+x*SL-SL+3, TopBorder+y*SL-SL+3, SL-6, SL-6);
        }
        else {
            _gr.setColor(MyStyles[c]);
            _gr.fillRect(LeftBorder+x*SL-SL, TopBorder+y*SL-SL, SL, SL);
            _gr.setColor(Color.black);
            _gr.drawRect(LeftBorder+x*SL-SL, TopBorder+y*SL-SL, SL, SL);
        }
        //		g.setColor (Color.black);
    }
    void DrawField(Graphics g) {
        int i,j;
        for (i=1; i<=Depth; i++) {
            for (j=1; j<=Width; j++) {
                DrawBox(j,i,Fnew[j][i]);
            }
        }
    }
    void DrawFigure(Figure f) {
    	if (f == null)
    		return;
    	int[] c = f.getCells();
        DrawBox(f.x,f.y, c[0]);
        DrawBox(f.x,f.y+1, c[1]);
        DrawBox(f.x,f.y+2, c[2]);
    }
    void DropFigure(Figure f) {
        int zz;
        if (f.y < Depth-2) {
            zz = Depth;
            while (Fnew[f.x][zz]>0) zz--;
            DropScore = (((Level+1)*(Depth*2-f.y-zz) * 2) % 5) * 5;
            f.y = zz-2;
        }
    }
    boolean FullField() {
        int i;
        for (i=1; i<=Width; i++) {
            if (Fnew[i][3]>0)
                return true;
        }
        return false;
    }
    void HideFigure(Figure f) {
        DrawBox(f.x,f.y,0);
        DrawBox(f.x,f.y+1,0);
        DrawBox(f.x,f.y+2,0);
    }
    public void init() {
        Fnew = new int[Width+2][Depth+2];
        Fold = new int[Width+2][Depth+2];
        _gr = getGraphics();
        _gr.setColor(Color.black);
    }
    public boolean keyDown(Event e, int k) {
        KeyPressed = true;
        ch = e.key;
        return true;
    }
    public boolean lostFocus(Event e, Object w) {
        KeyPressed = true;
        ch = 'P';
        return true;
    }
    void PackField() {
        int i,j,n;
        for (i=1; i<=Width; i++) {
            n = Depth;
            for (j=Depth; j>0; j--) {
                if (Fold[i][j]>0) {
                    Fnew[i][n] = Fold[i][j];
                    n--;
                }
            };
            for (j=n; j>0; j--) Fnew[i][j] = 0;
        }
    }
    public void paint(Graphics g) {
        //		ShowHelp(g);
        
        g.setColor(Color.black);
        
        ShowLevel(g);
        ShowScore(g);
        DrawField(g);
        DrawFigure(Fig);
        requestFocus();
    }
    void PasteFigure(Figure f) {
    	int[] c = f.getCells();
        Fnew[f.x][f.y] = c[0];
        Fnew[f.x][f.y+1] = c[1];
        Fnew[f.x][f.y+2] = c[2];
    }
    public void run() {
        initMatrixes();
        initMembers();
        requestFocus();
        
        do {
            tc = System.currentTimeMillis();
            Fig = new Figure();
            DrawFigure(Fig);
            while (mayFigureSlideDown()) {
                trySlideDown();
                DropScore = 0;
                do {
                    processUserActions();
                } while (!isItTimeToSlideDown());
            };
            PasteFigure(Fig);
            do {
                removeSimilarNeighboringCells();
            } while (!NoChanges);
        } while (!FullField());
        gameOver();
    }
	private void trySlideDown() {
		if (isItTimeToSlideDown()) {
		    tc = System.currentTimeMillis();
		    HideFigure(Fig);
		    Fig.y++;
		    DrawFigure(Fig);
		}
	}
	private void gameOver() {
		// TODO Auto-generated method stub
		
	}
	private boolean isItTimeToSlideDown() {
		return (int)(System.currentTimeMillis()-tc)>(MaxLevel-Level)*TimeShift+MinTimeShift;
	}
	private boolean mayFigureSlideDown() {
		return (Fig.y<Depth-2) && (Fnew[Fig.x][Fig.y+3]==0);
	}
	private void removeSimilarNeighboringCells() {
		NoChanges = true;
		TestField();
		if (!NoChanges) {
		    Delay(500);
		    PackField();
		    DrawField(_gr);
		    Score += DropScore;
		    ShowScore(_gr);
		    if (removedCellsCounter>=FigToDrop) {
		        removedCellsCounter = 0;
		        if (Level<MaxLevel) Level++;
		        ShowLevel(_gr);
		    }
		}
	}
	private void processUserActions() {
		Delay(50);
		if (KeyPressed) {
		    KeyPressed = false;
		    switch (ch) {
		        case Event.LEFT:
		            if ((Fig.x>1) && (Fnew[Fig.x-1][Fig.y+2]==0)) {
		                HideFigure(Fig);
		                Fig.x--;
		                DrawFigure(Fig);
		            }
		            break;
		        case Event.RIGHT:
		            if ((Fig.x<Width) && (Fnew[Fig.x+1][Fig.y+2]==0)) {
		                HideFigure(Fig);
		                Fig.x++;
		                DrawFigure(Fig);
		            }
		            break;
		        case Event.UP:
		        	Fig.rotateFigureCellsLeft();
		    		DrawFigure(Fig);
		            break;
		        case Event.DOWN:
		        	Fig.rotateFigureCellsRight();
		            DrawFigure(Fig);
		            break;
		        case ' ':
		            HideFigure(Fig);
		            DropFigure(Fig);
		            DrawFigure(Fig);
		            tc = 0;
		            break;
		        case 'P':
		        case 'p':
		            while (!KeyPressed) {
		                HideFigure(Fig);
		                Delay(500);
		                DrawFigure(Fig);
		                Delay(500);
		            }
		            tc = System.currentTimeMillis();
		            break;
		        case '-':
		            if (Level > 0) Level--;
		            removedCellsCounter=0;
		            ShowLevel(_gr);
		            break;
		        case '+':
		            if (Level < MaxLevel) Level++;
		            removedCellsCounter=0;
		            ShowLevel(_gr);
		            break;
		    }
		}
	}
	
	private void initMembers() {
		Level = 0;
        Score = 0;
        j = 0;
        removedCellsCounter = 0;
	}
	private void initMatrixes() {
		for (int i=0; i<Width+1; i++){
            for (j=0; j<Depth+1; j++) {
                Fnew[i][j] = 0;
                Fold[i][j] = 0;
            }
        }
	}
    void ShowHelp(Graphics g) {
        g.setColor(Color.black);
        
        g.drawString(" Keys available:",200-LeftBorder,102);
        g.drawString("Roll Box Up:     ",200-LeftBorder,118);
        g.drawString("Roll Box Down:   ",200-LeftBorder,128);
        g.drawString("Figure Left:     ",200-LeftBorder,138);
        g.drawString("Figure Right:    ",200-LeftBorder,148);
        g.drawString("Level High/Low: +/-",200-LeftBorder,158);
        g.drawString("Drop Figure:   space",200-LeftBorder,168);
        g.drawString("Pause:           P",200-LeftBorder,180);
        g.drawString("Quit:     Esc or Q",200-LeftBorder,190);
    }
    void ShowLevel(Graphics g) {
        g.setColor(Color.black);
        g.clearRect(LeftBorder+100,390,100,20);
        g.drawString("Level: "+Level,LeftBorder+100,400);
    }
    void ShowScore(Graphics g) {
        g.setColor(Color.black);
        g.clearRect(LeftBorder,390,100,20);
        g.drawString("Score: "+Score,LeftBorder,400);
    }
    public void start() {
        _gr.setColor(Color.black);
        
        //		setBackground (new Color(180,180,180));
        
        if (thr == null) {
            thr = new Thread(this);
            thr.start();
        }
    }
    public void stop() {
        if (thr != null) {
            thr.stop();
            thr = null;
        }
    }
    void TestField() {
        int i,j;
        for (i=1; i<=Depth; i++) {
            for (j=1; j<=Width; j++) {
                Fold[j][i] = Fnew [j][i];
            }
        }
        for (i=1; i<=Depth; i++) {
            for (j=1; j<=Width; j++) {
                if (Fnew[j][i]>0) {
                    CheckNeighbours(j,i-1,j,i+1,i,j);
                    CheckNeighbours(j-1,i,j+1,i,i,j);
                    CheckNeighbours(j-1,i-1,j+1,i+1,i,j);
                    CheckNeighbours(j+1,i-1,j-1,i+1,i,j);
                }
            }
        }
    }
}