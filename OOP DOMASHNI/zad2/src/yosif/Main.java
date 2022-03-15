package yosif;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> data = Arrays.stream(sc.nextLine().split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());

        loop: while (true) {
            List<String> input = Arrays.stream(sc.nextLine().split(" ")).toList();
            switch (input.get(0)) {
                case "print" -> System.out.println(data);

                case "add" -> {
                    int index = Integer.parseInt(input.get(1));
                    if(index > data.size()) {
                        System.out.println("The index is out of bounds!");
                        continue loop;
                    }
                    data.add(index, Integer.parseInt(input.get(2)));
                    System.out.println("Element successfully added!");
                }

                case "addMany" -> {
                    int index = Integer.parseInt(input.get(1));
                    if(index > data.size()) {
                        System.out.println("The index is out of bounds!");
                        continue loop;
                    }
                    ArrayList<Integer> numbersToAdd = new ArrayList<>();
                    for (int i = 2; i < input.size(); i++) {
                        numbersToAdd.add(Integer.parseInt(input.get(i)));
                    }
                    data.addAll(index, numbersToAdd);
                    System.out.println("Elements successfully added!");
                }

                case "remove" -> {
                    int index = Integer.parseInt(input.get(1));
                    if(index > data.size()) {
                        System.out.println("The index is out of bounds!");
                        continue loop;
                    }
                    data.remove(index);
                    System.out.println("Element successfully removed!");
                }

                case "contains" -> {
                    int element = Integer.parseInt(input.get(1));
                    if(data.contains(element)){
                        System.out.println(data.indexOf(element));
                    } else {
                        System.out.println(-1);
                    }
                }

                case "shift" -> {
                    Collections.rotate(data,-Integer.parseInt(input.get(1)));
                    System.out.println("The elements were successfully shifted " + Integer.parseInt(input.get(1)) + " to the left!");
                }

                case "sumPairs" -> {
                    List<Integer> result = new ArrayList<>();
                    for (int i = 0; i < data.size()-1; i+=2) {
                        result.add(data.get(i)+data.get(i+1));
                    }
                    if(data.size()%2==1){
                        result.add(data.get(data.size()-1));
                    }
                    data = result;
                }

                case "exit" -> {
                    break loop;
                }

                default -> System.out.println("Wrong command!");
            }
        }
    }
}