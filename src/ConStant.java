import base.Vector2D;

public class ConStant {
    public static class Windows{
        public static final int WIDTH = 1024;
        public static final int HEIGHT = 600;
        public static final long DELAY_TIME_INTERVAL = 17_000_000;
        public static final int EXIT = 1;
    }

    public static class Player{
        public static final Vector2D[]  VERTICES={
            new Vector2D(),
                    new Vector2D(0, 16),
                    new Vector2D(20, 8)
        };
    }
}
