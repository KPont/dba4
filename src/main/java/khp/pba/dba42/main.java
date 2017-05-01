/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khp.pba.dba42;

import javax.swing.JOptionPane;

/**
 *
 * @author Kasper
 */
public class main {
    public static void main(String[] args) {
        queries q = new queries();
        System.out.println("1");
//        System.out.println(q.getTweetsCount());
//        System.out.println(q.getUsersCount());
//        System.out.println(q.getMostActiveUsers());
        String input = JOptionPane.showInputDialog("Enter 1 for total amount of tweets\nEnter 2 for total amount of users\nEnter 3 for most active users\nEnter 4 for most grumpy users\nEnter 5 for most positive users");
        
        switch(input){
            case "1": JOptionPane.showMessageDialog(null, "Total amount of tweets: " + q.getTweetsCount());
            break;
            case "2": JOptionPane.showMessageDialog(null, "Total amount of users: " + q.getUsersCount());
            break;
            case "3": JOptionPane.showMessageDialog(null, "Top 10 most active users: " + q.getMostActiveUsers());
            break;
            case "4": JOptionPane.showMessageDialog(null, "Top 5 most grumpy/negative users: " + q.getMostGrumpyUsers());
            break;
            case "5": JOptionPane.showMessageDialog(null, "Top 5 most happy/positive users: " + q.getMostPositiveUsers());
            break;
        }
    }
}
