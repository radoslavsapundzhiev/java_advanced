public class Pokemon {
    private String name;
    private String element;
    private int health;
    private boolean isAlive;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
        this.isAlive = true;
    }

    public String getName() {
        return name;
    }

    public String getElement() {
        return element;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setHealth(int health) {
        this.health = health;
        if(this.health <= 0) {
            this.setAlive(false);
        }
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
