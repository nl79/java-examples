import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class SetAndHashSet {

    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public SetAndHashSet() {
    }

    public void run() {
        HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
    }
}
