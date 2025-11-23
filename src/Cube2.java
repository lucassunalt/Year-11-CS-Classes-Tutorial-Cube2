public class Cube2 {
    private int side;
    private String color;

    public Cube2() {
        this.side = 1;
        this.color = "black";
    }

    public Cube2(int side) {
        this();
        setSide(side);
    }

    public Cube2(int side, String color) {
        this();
        setSide(side);
        this.color = color;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side must be positive");
        }
        this.side = side;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int calculateVolume() {
        return side * side * side;
    }

    public int calculateSurfaceArea() {
        return 6 * side * side;
    }

    public Cube2 add(Cube2 otherCube) {
        double newSideSquared = Math.pow(this.side, 2) + Math.pow(otherCube.side, 2);
        double newSide = Math.sqrt(newSideSquared);
        if (newSide % 1 != 0) {
             throw new IllegalArgumentException("Resulting side is not an integer");
        }
        return new Cube2((int) newSide);
    }

    public Cube2 minus(Cube2 otherCube) {
        double newSideSquared = Math.pow(this.side, 2) - Math.pow(otherCube.side, 2);
        if (newSideSquared <= 0) {
             throw new IllegalArgumentException("Resulting side must be positive");
        }
        double newSide = Math.sqrt(newSideSquared);
        if (newSide % 1 != 0) {
             throw new IllegalArgumentException("Resulting side is not an integer");
        }
        return new Cube2((int) newSide);
    }

    public boolean equals(Cube2 otherCube) {
        if (otherCube == null) return false;
        return this.side == otherCube.side && this.color.equals(otherCube.color);
    }

    public String toString() {
        return "Cube{side=" + side + ", color=\"" + color + "\"}";
    }
}
