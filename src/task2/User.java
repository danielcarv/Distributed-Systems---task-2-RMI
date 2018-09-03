package task2;


public class User {
    
    private int id;
    private double imc;
    private String ip;
    private String password;

    public User() {
    }

    public User(int id, double imc, String ip, String password) {
        this.id = id;
        this.imc = imc;
        this.ip = ip;
        this.password = password;
    }

    public User(double imc, String ip, String password) {
        this.imc = imc;
        this.ip = ip;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
