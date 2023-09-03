package Bank_System;

public class Check_Account {
    private  double money=0;
    private int num_id_acc;
    private double currency_rate;
    private String currency_money;

    public double getMoney() {
        return money;
    }
    public void deposit(double sum, double percent, int year) {

        double deposit = (sum * (percent / 100)) * year;
        this.money+=deposit;


    }
    public void setMoney(double money) {
        this.money = money;
    }

    public int getNum_id_acc() {
        return num_id_acc;
    }

    public  static int IdGenerator() {
        int id_new=(int)(1+Math.random()*1000000000);
        return id_new;
    }
    public void Withdraw2(double withdraw){
        if(withdraw > this.money){
            System.out.println("you want to withdraw more than you hava");
        }
        else
        {
        this.money-=withdraw;
        }

    }


    public Check_Account(int money, int num_id_acc) {
        this.money = money;
        this.num_id_acc = num_id_acc;

    }

    public Check_Account() {
    }

    public void setNum_id_acc(int num_id_acc) {
        this.num_id_acc = num_id_acc;
    }

    public double getCurrency_rate() {
        return currency_rate;
    }

    public void setCurrency_rate(double currency_rate) {
        this.currency_rate = currency_rate;
    }
    public void addMoney(double sum){
        this.money+=sum;
    }

    public String getCurrency_money() {
        return currency_money;
    }

    public void setCurrency_money(String currency_money) {
        this.currency_money = currency_money;
    }

    @Override
    public String toString() {
        return "Check_Account{" +
                "money=" + money +
                ", num_id_acc=" + num_id_acc +
                ", currency_rate=" + currency_rate +
                ", currency_money='" + currency_money + '\'' +
                '}';
    }
};
