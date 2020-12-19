package esm.aoc.models.grid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coordinate3D {

    private int x;
    private int y;
    private int z;

    public Coordinate3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public List<Coordinate3D> getAdjacent() {
        List<Coordinate3D> coords = new ArrayList<>();
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    if (!(x == 0 && y == 0 && z == 0)) {
                        coords.add(new Coordinate3D(this.x + x, this.y + y, this.z + z));
                    }
                }
            }
        }
        return coords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate3D that = (Coordinate3D) o;
        return x == that.x && y == that.y && z == that.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return x + "," + y + "," + z;
    }
}
