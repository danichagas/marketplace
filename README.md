<div align="center">
  <img src="https://github.com/Danichagas/marketplace-java/assets/142562991/c0257000-8e8c-4559-b93d-0881e655c4f6">
  <p>ONLINE SUPERMARKET SYSTEM DEVELOPED IN JAVA</p>
</div>

## ❗About the project❗

A project entirely developed in **Java**, using methods, classes and constructors, in this project you will be able to see your cart, register your products and buy them, all in one project

## 💻 Technologies
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white">

## 🛠 Tools
<img src="https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white">
<img src="https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white">
<img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white">

## How was the project developed❓
Most of the project was developed with methods that are separated by: <br/>
→ **Register** <br/>
→ **List** <br/>
→ **Buy** <br/>
→ **View cart**

## 💡 Methods
### ✔ Register products:
```
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
```

### ✔ List products:
```
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
```

### ✔ Buy products
```
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
```

### ✔ View cart
```

    private static void toSeeCart() {
        System.out.println("--- Produtos no seu carrinho! ---");
        if (cart.size() > 0) {
            for (Product p : cart.keySet()) {
                System.out.println("Produto " + p + "\nQuantidade: " + cart.get(p));
            }
        } else {
            System.out.println("Carrinho vazio!");
        }

        menu();
    }
```
