public class GameOfLife
{
    public static boolean rule(GridDisplay d, Location loc)
    {
        Color black;
        black = new Color(0, 0, 0);
        Color white;
        white = new Color(255, 255, 255);
        Color notBlack;
        notBlack = new Color(1, 1, 1);
        Color notWhite;
        notWhite = new Color(254, 254, 254);
        int row = loc.getRow();
        int col = loc. getCol();
        Location one;
        Location two;
        Location three;
        Location four;
        Location five;
        Location six;
        Location seven;
        Location eight;
        one = new Location(row-1, col-1);
        two = new Location(row-1, col);
        three = new Location(row-1, col+1);
        four = new Location(row, col-1);
        five = new Location(row, col+1);
        six = new Location(row+1, col-1);
        seven = new Location(row+1, col);
        eight = new Location(row+1, col+1);
        Color onec;
        Color twoc;
        Color threec;
        Color fourc;
        Color fivec;
        Color sixc;
        Color sevenc;
        Color eightc;
        onec = d.getColor(one);
        twoc = d.getColor(two);
        threec = d.getColor(three);
        fourc = d.getColor(four);
        fivec = d.getColor(five);
        sixc = d.getColor(six);
        sevenc = d.getColor(seven);
        eightc = d.getColor(eight);
        Color locc;
        locc = d.getColor(loc);
        int c = 0;
        if(onec.equals(black) || onec.equals(notBlack))
        {
            c++;
        }
        if(twoc.equals(black) || twoc.equals(notBlack))
        {
            c++;
        }
        if(threec.equals(black) || threec.equals(notBlack))
        {
            c++;
        }
        if(fourc.equals(black) || fourc.equals(notBlack))
        {
            c++;
        }
        if(fivec.equals(black) || fivec.equals(notBlack))
        {
            c++;
        }
        if(sixc.equals(black) || sixc.equals(notBlack))
        {
            c++;
        }
        if(sevenc.equals(black) || sevenc.equals(notBlack))
        {
            c++;
        }
        if(eightc.equals(black) || eightc.equals(notBlack))
        {
            c++;
        }
        if(locc.equals(white))
        {
            if(c == 3)
                return true;
            else
                return false;
        }
        else
        if(locc.equals(black))
        {
            if(c == 2 || c == 3)
                return true;
            else
                return false;
        }
        else
            return false;
    }

    public static void makeBlack(GridDisplay d, Location loc)
    {
        Color black;
        black = new Color(0, 0, 0);
        d.setColor(loc, black);        
    }

    public static void makeNotBlack(GridDisplay d, Location loc)
    {
        Color notBlack;
        notBlack = new Color(1, 1, 1);
        d.setColor(loc, notBlack);        
    }

    public static void makeWhite(GridDisplay d, Location loc)
    {
        Color white;
        white = new Color(255, 255, 255);
        d.setColor(loc, white);        
    }

    public static void makeNotWhite(GridDisplay d, Location loc)
    {
        Color notWhite;
        notWhite = new Color(254, 254, 254);
        d.setColor(loc, notWhite);        
    }

    public static void life()
    {
        Color black;
        black = new Color(0, 0, 0);
        Color notBlack;
        notBlack = new Color(1, 1, 1);
        Color white;
        white = new Color(255, 255, 255);
        Color notWhite;
        notWhite = new Color(254, 254, 254);
        GridDisplay d;
        d = new GridDisplay("gol.png");
        int rows = d.getNumRows();
        int cols = d.getNumCols();
        while(true)
        {
            for(int i = 1; i < rows - 1; i++)
            {
                for(int j = 1; j < cols - 1; j++)
                {
                    Location loc;
                    loc = new Location(i, j);
                    Color current;
                    current = d.getColor(loc);
                    if(current.equals(black))
                    {
                        if(rule(d, loc))
                        { 
                        }
                        else
                            makeNotBlack(d, loc);
                    }
                    if(current.equals(white))
                    {
                        if(rule(d,loc))
                            makeNotWhite(d, loc);
                    }
                }
            }
            for(int i = 1; i < rows - 1; i++)
            {
                for(int j = 1; j < cols - 1; j++)
                {
                    Location loc;
                    loc = new Location(i, j);
                    Color current;
                    current = d.getColor(loc);
                    if(current.equals(notBlack))
                    {
                        makeWhite(d, loc);
                    }
                    if(current.equals(notWhite))
                    {
                        makeBlack(d, loc);
                    }
                }
            }
            try
            {
                Thread.sleep(100);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
    }
}
