
### **Exercice 9 : API de gestion des produits avec stock**

#### **Objectif**
Créer une API réactive pour gérer un catalogue de produits, en ajoutant des fonctionnalités de gestion des stocks.

---

#### **Instructions**
1. **Créez une entité `Product`** avec les propriétés suivantes :
    - `id` (Long) : Identifiant unique (généré automatiquement).
    - `name` (String) : Nom du produit.
    - `price` (Double) : Prix du produit.
    - `stock` (Integer) : Quantité disponible en stock.

2. **Créez un repository réactif** pour interagir avec la base de données.

3. **Ajoutez un service** pour encapsuler la logique métier, avec les fonctionnalités suivantes:
    - Récupérer tous les produits.
    - Récupérer un produit par ID.
    - Créer un nouveau produit.
    - Mettre à jour les informations d’un produit (par exemple, prix ou stock).
    - Supprimer un produit.
    - Rechercher des produits par nom (filtrage).
    - Réduire le stock d’un produit après un achat (avec validation).

4. **Ajoutez un contrôleur** pour exposer les endpoints suivants :
    - **GET `/api/products`** : Retourne tous les produits.
    - **GET `/api/products/{id}`** : Retourne un produit par ID.
    - **POST `/api/products`** : Crée un nouveau produit.
    - **PUT `/api/products/{id}`** : Met à jour un produit.
    - **DELETE `/api/products/{id}`** : Supprime un produit.
    - **GET `/api/products/search?name=phone`** : Recherche des produits par nom.
    - **PUT `/api/products/{id}/buy?quantity=5`** : Réduit le stock d’un produit.

5. **Ajoutez un fichier SQL `schema.sql`** pour créer la table `products`.

6. Testez les endpoints avec des outils comme **Postman**, **Insomnia**, ou **curl**.

---

#### **Challenge supplémentaire**
- Implémentez un contrôle du stock:
    - Si la quantité demandée dépasse le stock disponible, retournez une erreur avec un message adapté.

---

### **Livrables attendus**
1. **Code source complet** pour chaque API (entités, repository, services, contrôleurs).
2. **Fichier SQL** pour créer les tables correspondantes.
3. **README** avec la description du projet, les endpoints, et des exemples JSON pour les tests.