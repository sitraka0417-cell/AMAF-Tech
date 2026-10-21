# AMAF Imamo Tech — Projet Gradle (compilation via GitHub Actions)

## ⚠️ État actuel de ce squelette

Ce premier paquet est un **squelette qui compile** : toutes les activités
existent et le projet doit réussir à builder sur GitHub Actions, mais la
plupart des écrans sont pour l'instant des **stubs** (juste un texte
"Mbola tsy vita ity pejy ity").

Les vraies activités déjà conçues ensemble (PinActivity, MainActivity admin,
SettingsActivity, ChangepinActivity, RaharahaActivity x2, MpitarikaActivity
x2, SampanaharivaActivity, DiakonaActivity, MenuActivity) seront envoyées
**dans les prochains messages**, une par une ou par petits groupes, pour
éviter de perdre le travail si l'environnement de génération replante — ce
qui est déjà arrivé plusieurs fois pendant la construction de ce paquet.

Remplace simplement chaque fichier `.java` stub par la version complète au
fur et à mesure que je te les donne — le chemin ne change pas.

## 1. Comment pousser ce projet sur GitHub

```bash
cd AMAFImamoTech
git init
git add .
git commit -m "Squelette initial AMAF Imamo Tech"
git branch -M main
git remote add origin https://github.com/TON_COMPTE/TON_DEPOT.git
git push -u origin main
```

Le workflow `.github/workflows/build.yml` se déclenche automatiquement à
chaque `push` sur `main`. Va dans l'onglet **Actions** de ton dépôt GitHub
pour suivre la compilation, puis dans le résultat du run terminé →
**Artifacts** → télécharge `amaf-imamo-apks` (contient les deux APK debug).

## 2. Où déposer tes icônes (remplace les placeholders)

Les icônes actuelles sont des **cercles de couleur unie** générés
automatiquement (vecteurs `.xml`), juste pour que le projet compile. Pour
mettre tes vraies images, **supprime le fichier `.xml` du même nom** et
dépose ton image (`.png` ou `.webp`) avec **exactement ce nom de fichier**,
dans **les deux dossiers** (app-user ET app-admin) :

```
app-user/src/main/res/drawable/raharaha.png
app-user/src/main/res/drawable/mpitarika.png
app-user/src/main/res/drawable/sampana.png
app-user/src/main/res/drawable/fifandraisana.png
app-user/src/main/res/drawable/maika.png
app-user/src/main/res/drawable/sabata.png
app-user/src/main/res/drawable/vavaka.png
app-user/src/main/res/drawable/hafatra.png
app-user/src/main/res/drawable/splash.png
app-user/src/main/res/drawable/phone.png
app-user/src/main/res/drawable/mail.png
app-user/src/main/res/drawable/whatsapp.png
app-user/src/main/res/drawable/facebook.png

app-admin/src/main/res/drawable/   (les memes noms)
```

⚠️ Règles Android sur les noms de fichiers drawable : uniquement minuscules,
chiffres et underscore `_`, pas d'espace ni de majuscule.

## 3. Firebase — déjà configuré

Les deux fichiers `google-services.json` sont déjà en place
(`app-user/google-services.json` et `app-admin/google-services.json`), issus
de ton projet Firebase `discusecret`. Rien à faire ici.

**Rappel des règles Realtime Database à publier** (Firebase Console →
Realtime Database → Rules) :

```json
{
  "rules": {
    "raharaha": { ".read": true, ".write": "auth != null" },
    "mpitarika": { ".read": true, ".write": "auth != null" },
    "sampana": { ".read": true, ".write": "auth != null" },
    "fifandraisana": { ".read": true, ".write": "auth != null" },
    "maika": { ".read": true, ".write": "auth != null" },
    "vavaka": { ".read": true, ".write": "auth != null" },
    "diakona": { ".read": true, ".write": "auth != null" },
    "sampanahariva": { ".read": true, ".write": "auth != null" },
    "hafatra": { ".read": "auth != null", ".write": true }
  }
}
```

(`hafatra` : écriture libre pour que les utilisateurs sans compte puissent
envoyer un message, lecture réservée à l'admin connecté.)

## 4. Structure du projet

```
AMAFImamoTech/
├── settings.gradle
├── build.gradle
├── gradle.properties
├── .github/workflows/build.yml
├── app-user/                    (com.amaf.imamo)
│   ├── build.gradle
│   ├── google-services.json
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/amaf/imamo/*.java
│       └── res/
│           ├── values/ (themes.xml, strings.xml)
│           └── drawable/ (icones)
└── app-admin/                   (com.amaf.imamo.admin)
    ├── build.gradle
    ├── google-services.json
    └── src/main/  (meme structure)
```

## 5. Prochaines étapes

1. Pousse ce squelette sur GitHub et vérifie que les 2 APK se compilent
   (onglet Actions)
2. Je t'envoie les vraies activités une par une (en remplacement des stubs)
3. Je code **HafatraActivity** (admin + utilisateurs) et le système de
   notification "3 jours avant" basé sur le nom complet enregistré
4. Dépose tes vraies icônes quand tu les as
