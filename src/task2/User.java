package task2;


public class User {
    
    private int id;
    private double imc;
    private String ip;
    private String cpf;

    public User() {
    }

    public User(int id, double imc, String ip, String cpf) {
        this.id = id;
        this.imc = imc;
        this.ip = ip;
        this.cpf = cpf;
    }

    public User(double imc, String ip, String cpf) {
        this.imc = imc;
        this.ip = ip;
        this.cpf = cpf;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
    
}
