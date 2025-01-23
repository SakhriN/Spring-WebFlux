### **Exercice 8 : API de gestion des commandes**

#### **Objectif**
Créer une API réactive pour gérer des **commandes** dans un système de commerce en ligne, en utilisant Spring WebFlux et R2DBC.

---

#### **Instructions**
1. **Créez une entité `Order`** avec les propriétés suivantes :
    - `id` (Long) : Identifiant unique (généré automatiquement).
    - `customerName` (String) : Nom du client.
    - `totalAmount` (Double) : Montant total de la commande.
    - `status` (String) : Statut de la commande (`PENDING`, `SHIPPED`, `DELIVERED`).
    - `createdAt` (LocalDateTime) : Date de création (générée automatiquement).

2. **Créez un repository réactif** pour interagir avec la base de données.

3. **Ajoutez un service** pour encapsuler la logique métier, avec les fonctionnalités suivantes:
    - Récupérer toutes les commandes.
    - Récupérer une commande par ID.
    - Créer une nouvelle commande avec un statut par défaut `PENDING`.
    - Mettre à jour le statut d’une commande existante.
    - Supprimer une commande.

4. **Ajoutez un contrôleur** pour exposer les endpoints suivants :
    - **GET `/api/orders`** : Retourne toutes les commandes.
    - **GET `/api/orders/{id}`** : Retourne une commande par ID.
    - **POST `/api/orders`** : Crée une nouvelle commande.
    - **PUT `/api/orders/{id}`** : Met à jour le statut d’une commande.
    - **DELETE `/api/orders/{id}`** : Supprime une commande par ID.
    - **GET `/api/orders/search?status=SHIPPED`** : Recherche les commandes par statut.
    - **GET `/api/orders/paged?page=0&size=5`** : Retourne les commandes paginées.

5. **Ajoutez un fichier SQL `schema.sql`** pour créer la table `orders`.

6. Testez les endpoints avec des outils comme **Postman**, **Insomnia**, ou **curl**.
---

#### **Challenge supplémentaire**
- Ajoutez un endpoint permettant de lister les commandes d’un client spécifique :
   - **GET `/api/orders/customer/{customerName}`**