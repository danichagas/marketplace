package main;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Marketplace {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList <Product> products;
    private static Map <Product, Integer> cart;

    public static void main(String[] args) {
        products = new ArrayList<>();
        cart = new HashMap<>();
        menu();
    }

    private static void menu() {

        System.out.println("--------------------------------------------------------------");
        System.out.println("------------Welcome to Daniel Chagas Market------------");
        System.out.println("--------------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("--------------------------------------------------------------");
        System.out.println("|    Opção 1 - Cadastrar       |");
        System.out.println("|    Opção 2 - Listar          |");
        System.out.println("|    Opção 3 - Comprar         |");
        System.out.println("|    Opção 4 - Carrinho        |");
        System.out.println("|    Opção 5 - Sair            |");

        int option = input.nextInt();

        switch (option) {
            case 1:
                registerProducts();
                break;
            case 2:
                listProducts();
                break;
            case 3:
                purchaseProducts();
                break;
            case 4:
                toSeeProducts();
                break;
            case 5:
                System.out.println("Obrigado pela preferência e volte sempre! <3");
                System.exit();
            default:
                System.out.println("Opção Inválida!");
                menu();
                break;
        }
    }

    private static void registerProducts() {
        System.out.println("Nome do produto: ");
        String name = input.next();

        System.out.println("Preço do produto: ");
        Double price = input.nextDouble();

        Product product = new Product(name, price);
        products.add(product);

        System.out.println(product.getName() + " foi cadastrado com sucesso!");
        menu();
    }

    private static void listProducts() {
        if (products.size() > 0) {
            System.out.println("Lista de produtos! \n");

            for (Product p : products) {
                System.out.println(p);
            }
        }else {
            System.out.println("Nenhum produto cadastrado!");
        }

        menu();
    }

    private static void purchaseProducts() {

    }
}
