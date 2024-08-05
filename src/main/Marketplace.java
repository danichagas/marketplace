package main;

import model.Product;
import services.ProductService;
import utils.Utils;

import java.util.*;

public class Marketplace {


    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        ProductService.input = new Scanner(System.in);
        ProductService.products = new ArrayList<>();
        ProductService.cart = new HashMap<>();
        menu();
    }


    // ---------- Método do menu da loja ----------

    public static void menu() {

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

        int option = ProductService.input.nextInt();

        switch (option) {
            case 1:
                ProductService.registerProducts();
                break;
            case 2:
                ProductService.listProducts();
                break;
            case 3:
                ProductService.purchaseProducts();
                break;
            case 4:
                ProductService.toSeeCart();
                break;
            case 5:
                System.out.println("Obrigado pela preferência e volte sempre! <3");
                System.exit(0);
            default:
                System.out.println("Opção Inválida!");
                menu();
                break;
        }
    }
}