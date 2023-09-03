package Bank_System;

import java.io.IOException;
import java.util.*;

public class Main_menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int user_choose = 0;
        boolean flag = false;
        int valid_count = 3;
        Enter_user enter_user = new Enter_user();
        Map<String, User> user_base = new HashMap<>();
        Map<String, Check_Account> usercheck_base = new HashMap<>();

        String password = null;
        int size = 0;
        String login = null;
        while (user_choose != 5) {
            System.out.println("Chose your option");
            System.out.println("1. - Create account \n" +
                    "2. - Login \n" +
                    "3. - Update account \n" +
                    "4. - Base \n" +
                    "5. - Exit ");

            user_choose = sc.nextInt();

            if (user_choose == 1) {
                sc.nextLine();
                System.out.print("Enter name : ");
                String name = sc.nextLine();
                System.out.print("Enter surname : ");
                String surname = sc.nextLine();

                while (flag != true) {
                    System.out.println("Set login : ");
                    login = sc.nextLine();
                    if (!user_base.containsKey(login)) {
                        flag = true;
                    }
                }

                while (size < 4) {
                    System.out.println("Set password : ");
                    password = sc.nextLine();
                    size = password.length();

                }
                System.out.print("Enter email : ");
                String email = sc.nextLine();

                while (CheckEmail(email, user_base) != true) {
                    System.out.print("Enter email : ");
                    email = sc.nextLine();

                }


                User user = new User(name, surname, login, email, password);
                int id = Enter_user.IdGenerator();
                System.out.println(id);
                if (user_base.containsKey(login)) {
                    System.out.println("user exists, choose another login");
                } else {
                    enter_user = new Enter_user(id, login);
                    System.out.println(enter_user.toString());
                    user_base.put(login, user);
                }
            }
            if (user_choose == 3) {
                sc.nextLine();
                System.out.println("Enter login : ");
                String login_update = sc.nextLine();
                User user_map = new User();

                if (user_base.containsKey(login_update)) {
                    user_map = user_base.get(login_update);
                    System.out.println("Enter password : ");
                    password = sc.nextLine();
                    if (password.equals(user_map.getPassword())) {
                        System.out.println(user_map);
                        user_base.remove(login);
                        System.out.print("Enter  new name : ");
                        String name = sc.nextLine();
                        System.out.print("Enter new surname : ");
                        String surname = sc.nextLine();


                        while (flag != true) {
                            System.out.println("Set new login : ");
                            login = sc.nextLine();
                            if (!user_base.containsKey(login)) {
                                flag = true;
                            }
                        }
                        user_map.setLogin(login);
                        user_base.put(login, user_map);


                        while (size < 4) {
                            System.out.println("Set new password : ");
                            password = sc.nextLine();
                            size = password.length();

                        }
                        System.out.print("Enter email : ");
                        String email = sc.nextLine();

                        while (CheckEmail(email, user_base) != true) {
                            System.out.print("Enter email : ");
                            email = sc.nextLine();

                        }
                        user_map.setName(name);
                        user_map.setSurname(surname);
                        user_map.setPassword(password);
                        user_map.setEmail(email);

                        System.out.println("You updated your acc");

                    } else {
                        System.out.println("invalid pass");
                    }
                } else {
                    System.out.println("there aren't such user");
                }

            }
            if (user_choose == 2) {
                sc.nextLine();
                System.out.println("Set login : ");
                login = sc.nextLine();
                System.out.println("Set password : ");
                String password_login = sc.nextLine();
                if (user_base.containsKey(login)) {
                    User user_map = user_base.get(login);
                    String map_user_pass = user_map.getPassword();

                    if (password_login.equals(map_user_pass)) {
                        System.out.println(user_map);
                        System.out.println("You enter to system");
                        Check_Account check = new Check_Account();
                        System.out.println("Input your balance");
                        double balance = sc.nextInt();
                        check.addMoney(balance);
                        System.out.println("Input currency rate");
                        double currency_rate = sc.nextDouble();
                        check.setCurrency_rate(currency_rate);
                        int id_card = check.IdGenerator();
                        check.setNum_id_acc(id_card);
                        System.out.println("Your card id");
                        System.out.println(id_card);
                        user_map.setNum_id_card(id_card);
                        int check_operation_check = 1;
                        user_map.setCheck_account(check);
                        while (check_operation_check != 0) {
                            System.out.println("Choose what transactions you want to make \n" +
                                    "1. - withdraw \n" +
                                    "2. - deposit \n" +
                                    "3. - balance \n" +
                                    "4. - send to another account \n" +
                                    "0. - exit \n"
                            );
                            check_operation_check = sc.nextInt();
                            if (check_operation_check == 1) {
                                System.out.println("Input sum you want to withdraw");
                                int money_withdraw;
                                money_withdraw = sc.nextInt();
                                check.Withdraw2(money_withdraw);


                                System.out.println("Your balance " + check.getMoney());

                            }
                            if (check_operation_check == 2) {
                                System.out.println("Input percent");
                                double percent;
                                percent = sc.nextInt();
                                System.out.println("Enter sum");
                                int sum;
                                sum = sc.nextInt();
                                System.out.println("Enter years");
                                int years = sc.nextInt();
                                check.deposit(sum, percent, years);
                            }
                            if (check_operation_check == 3) {
                                System.out.println("your balance " + check.getMoney());
                            }
                            if (check_operation_check == 4) {

                                System.out.println(" 1. - Enter user login you want send money");
                                System.out.println(" 2. - Enter user number card you want send money");
                                int user_choose_option = sc.nextInt();

                                if (user_choose_option == 1) {
                                    sc.nextLine();
                                    System.out.println("Enter user login");
                                    String user_send = sc.nextLine();
                                    Optional<User> check_user_exists = findUser(user_base,user_send);
                                    if(check_user_exists.isPresent()){
//                                        check_user_exists.map(User::getName).orElse("there re no such user");
                                        System.out.println(check_user_exists.get());
                                        System.out.println(user_map.getCheck_account());
                                        User user_send_money = user_base.get(user_send);
                                        Check_Account send_user_checkacc = new Check_Account();
                                        user_send_money.setCheck_account(send_user_checkacc);
                                        System.out.println(user_send_money);
                                        System.out.println("Enter sum you want to send");
                                        double sum_send = sc.nextDouble();
                                        user_map.getCheck_account().Withdraw2(sum_send);
                                        user_send_money.getCheck_account().addMoney(sum_send);
                                        System.out.println(user_send_money.getCheck_account().getMoney());
                                    }else {

                                    }

                                }


                            }
                            if (check_operation_check == 0) {
                                user_map.setCheck_account(check);
                                System.out.println(user_map.getCheck_account());
                            }

                        }

                    } else {
                        System.out.println("invalid pass");
                    }
                } else {
                    System.out.println("invalid input");
                }
            }
            if (user_choose == 4) {
                Base_print(user_base);
            }
            size = 0;
            flag = false;
        }
    }

    public static boolean CheckEmail(String str, Map<String, User> user_base) {
        boolean flag = false;
        int count = 0;
        for (User user : user_base.values()) {
            if (user.getEmail().equals(str)) {
                flag = false;
                count++;
            }
        }
        if (count >= 1) {
            flag = false;
            return flag;
        } else {
            if (str.length() > 10 && str.contains("@") && str.contains(".com") || str.contains(".net")) {
                flag = true;
            } else {
                flag = false;
            }
        }


        return flag;
    }

    public static void Base_print(Map<String, User> base) {

        for (Map.Entry<String, User> i : base.entrySet()) {
            System.out.println(i);
        }
    }

    public static Optional<User> findUser(Map<String, User> map,String login) {
        User find_user=new User();
if(map.containsKey(login)){
    find_user= map.get(login);
}
return Optional.ofNullable(find_user);
    }
}

//    if (user_base.containsKey(user_send)) {
//            System.out.println("this account exists");
//            System.out.println(user_map.getCheck_account());
//            User user_send_money = user_base.get(user_send);
//            Check_Account send_user_checkacc = new Check_Account();
//            user_send_money.setCheck_account(send_user_checkacc);
//            System.out.println(user_send_money);
//            System.out.println("Enter sum you want to send");
//            double sum_send = sc.nextDouble();
//            user_map.getCheck_account().Withdraw2(sum_send);
//            user_send_money.getCheck_account().addMoney(sum_send);
//            System.out.println(user_send_money.getCheck_account().getMoney());
//
//            } else {
//            System.out.println("invalid login");
//            }