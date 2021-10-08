package sort;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Sort10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<User> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            list.add(new User(Integer.parseInt(temp[0]), temp[1],i));
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            bw.write(user.age + " " + user.name + "\n");
        }
        bw.close();
    }
}

class User implements Comparable<User> {
    int age, joined;
    String name;

    public User(int age, String name, int joined) {
        this.age = age;
        this.name = name;
        this.joined = joined;
    }

    @Override
    public int compareTo(User u) {
        if (this.age > u.age) {
            return 1; 
        } else if (this.age == u.age) {
            if (this.joined > u.joined) { 
                return 1;
            }
        }
        return -1;
    }
}