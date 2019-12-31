import java.util.Set;
import java.util.HashSet;

public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return this.name;
    }

    public double getOrbitalPeriod() {
        return this.orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<HeavenlyBody>(this.satellites);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        System.out.println("object.getClass() " + object.getClass());
        System.out.println("this.getClass() " + this.getCass());

        if((object == null) || object.getClass() != this.getClass()) {
            return false;
        }

        String objectName = ((HeavenlyBody) object).getName();
        return this.name.equals(objectName);
    }

    @Override
    public int hashCode() {
        System.out.println("hasCode()");
        return this.name.hashCode() + 57;
    }
}
