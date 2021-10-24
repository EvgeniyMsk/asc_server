package ou.acs.entity;

public class IdGenerator {
    private static IdGenerator instance;
    private static int id;

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        if (instance == null)
            instance = new IdGenerator();
        return instance;
    }

    public int generateId() {
        return id++;
    }
}
