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


    // ---------- Método do menu da loja ----------

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


    // ---------- Método para registrar os produtos da nossa loja ----------

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


    // ---------- Método para a listagem de nossos produtos ----------

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


    // ---------- Método para a compra de nossos produtos da loja ----------

    private static void purchaseProducts() {
        if (products.size() > 0) {
            System.out.println("Código do produto \n");

            System.out.println("--------------Produtos Disponíveis--------------");
            for (Product p : products) {
                System.out.println(p + "\n");
            }
            int id = Integer.parseInt(input.next());
            boolean isPresent = false;

            for (Product p : products) {
                if (p.getId() == id) {
                    int quantity = 0;
                    try {
                        quantity = cart.get(p);
                        // ----- Checa se o produto já está no carrinho, incrementa quantidade
                        cart.put(p, quantity + 1);
                    } catch (NullPointerException e) {
                        // ----- Se o produto for o primeiro do carrinho -----
                        cart.put(p, 1);
                    }

                    System.out.println(p.getName() + "adicionado no carrinho!");
                    isPresent = true;

                    if (isPresent) {
                        System.out.println("Deseja adicionar outro produto ao carrinho? ");
                        System.out.println("Digite 1 para sim, ou 0 para finalizar a compra. \n");
                        int option = Integer.parseInt(input.next());

                        if (option == 1) {
                            purchaseProducts();
                        } else {
                            finishPurchase();
                        }
                    }
                } else {
                    System.out.println("Produto não encontrado :/");
                    menu();
                }
            }
        } else {
            System.out.println("Não existem produtos cadastrados!");
            menu();
        }
    }
}
