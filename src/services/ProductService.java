package services;

import main.Marketplace;
import model.Product;
import utils.Utils;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class ProductService {
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Product> products;
    public static Map<Product, Integer> cart;

    // Registrar produto
    public static void registerProducts() {
        System.out.println("Nome do produto: ");
        String name = input.nextLine();
        input.nextLine();
        System.out.println("Preço do produto: ");

        Double price = input.nextDouble();

        Product product = new Product(name, price);
        products.add(product);

        System.out.println(product.getName() + " foi cadastrado com sucesso!");
        Marketplace.menu();
    }

    public static void listProducts() {
        if (products.size() > 0) {
            System.out.println("Lista de produtos! \n");

            for (Product p : products) {
                System.out.println(p);
            }
        }else {
            System.out.println("Nenhum produto cadastrado!");
        }

        Marketplace.menu();
    }

    // Comprar produto
    public static void purchaseProducts() {
        if (products.size() > 0) {
            System.out.println("Código do produto: \n");

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

                    System.out.println(p.getName() + " adicionado no carrinho!");
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
                    Marketplace.menu();
                }
            }
        } else {
            System.out.println("Não existem produtos cadastrados!");
            Marketplace.menu();
        }
    }

    // Ver carrinho
    public static void toSeeCart() {
        System.out.println("--- Produtos no seu carrinho! ---");
        if (cart.size() > 0) {
            for (Product p : cart.keySet()) {
                System.out.println("Produto " + p + "\nQuantidade: " + cart.get(p));
            }
        } else {
            System.out.println("Carrinho vazio!");
        }

        Marketplace.menu();
    }

    // Finalizar compra
    public static void finishPurchase() {
        Double totalValue = 0.0;
        System.out.println("Seus produtos!");

        for (Product p : cart.keySet()) {
            int quantity = cart.get(p);
            totalValue += p.getPrice() * quantity;
            System.out.println(p);
            System.out.println("Quantidade: " + quantity);
            System.out.println("-------------------------");
        }
        System.out.println("O valor da sua compra é: " + Utils.doubleToString(totalValue));
        cart.clear();
        System.out.println("Obrigado e volte sempre!");
    }
}
