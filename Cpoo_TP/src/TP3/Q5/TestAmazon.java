package TP3.Q5;

public class TestAmazon {
    public static void main(String[] args) {
        Article ball, apple, book, ball2;
        DetailCommande detail1, detail2, detail3, detail4, detail5;
        Commande com1, com2;

        /** OBJETS IMMUTABLES
         *  -----------------
         * equals vaut true si ils ont le même état
         * moins restrictif que == (vérification du partage de référence)
         *
         * Il faut réimplémenter equals ET hashCode
         *
         * => Equivalence comportementale
         * */

        ball = new Article("ball", 524);
        ball2 = new Article("ball", 524);
        apple = new Article("apple", 457);
        book = new Article("book", 24);

        System.out.println(ball == ball2);
        System.out.println(ball.equals(ball2));
        System.out.println(ball == apple);
        System.out.println(ball.equals(book));

        /** OBJETS MUTABLES
         *  ---------------
         *  equals et == doivent renvoyer la même chose!
         *  On ne réimplemente ni equals ni hashCode
         *  Pour regarder si 2 objets mutables sont semblables, on implémente similar
         *
         *  similar renvoie true si 2 objets ont le même contenu
         *
         *  => Equivalence observationnelle
         * */

        detail1 = new DetailCommande(ball, 52.2f, 3);
        detail2 = new DetailCommande(ball, 52.2f, 3);
        detail3 = new DetailCommande(apple, 2f, 2);
        detail4 = new DetailCommande(book, 18f, 1);
        detail5 = new DetailCommande(ball2, 52.2f, 3);

        System.out.println(detail1);
        System.out.println(detail5);

        System.out.println("\nTest par rapport au même article");
        System.out.println(detail1.similar(detail2));
        System.out.println(detail1.equals(detail2));
        System.out.println(detail1 == detail2);

        System.out.println("\nTest par rapport à un article qui renvoie true lors du equals");
        System.out.println(detail1.similar(detail5));
        System.out.println(detail1.equals(detail5));
        System.out.println(detail1 == detail5);


        com1 = new Commande();
        com2 = new Commande();

        com1.insert(detail5);
        com1.insert(detail5);

        com2.insert(detail5);
        com2.insert(detail5);

        System.out.println("\nTest par rapport à des commandes semblables");
        System.out.println(com1.similar(com2));
        System.out.println(com1.equals(com2));
        System.out.println(com1 == com2);

        com1.insert(detail3);
        com1.insert(detail4);
        com1.insert(detail1);

        com2.insert(detail2);

        System.out.println("\nTest par rapport à des commandes différentes");
        System.out.println(com1.similar(com2));
        System.out.println(com1.equals(com2));
        System.out.println(com1 == com2);
    }
}
