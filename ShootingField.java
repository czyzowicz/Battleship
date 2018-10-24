package sda.java9.prog1.battleship;

public class ShootingField extends Field {
    
    private boolean miss;
    private boolean hitAndSink;
    
    public ShootingField(String row, String col, boolean miss, boolean hitAndSink) {
        super(row, col);
        this.miss = miss;
        this.hitAndSink = hitAndSink;
    }
    
    public boolean isMiss() { return miss; }
    public boolean isHitAndSink() { return hitAndSink; }
    
    public String toString() {
        return "ShootingField{miss=" + miss + ",hitAndSink" + hitAndSink + "} is " + super.toString();
    }
}