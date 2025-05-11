# ⚙️ **GitMiner** ⚙️

Bienvenido a **GitMiner**, una herramienta de minería de repositorios Git (información de repositorios, tales como carga, procesamiento y análisis de datos de proyectos) en ***GitHub*** y ***Bitbucket*** mediante sus APIs.

---

## 📚 Documentación de la API · Swagger

La documentación completa de la API REST de GitMiner está disponible mediante Swagger en el siguiente enlace:

🔗 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

Desde ahi se puede explorar todos los endpoints disponibles directamente desde tu navegador al ejecutar el proyecto.

---

## 🧪 Colección de pruebas · Postman

- Se incluye una **colección de Postman** que se utilizó para hacer las pruebas. 
- 📂 Puedes importarla directamente en Postman de la siguiente manera:

### 📥 Instrucciones para importar la colección en Postman

1️⃣ Abre Postman  
2️⃣ Haz clic en el botón **"Import"** (esquina superior izquierda)  
3️⃣ Selecciona la pestaña **"Upload Files"**  
4️⃣ Busca y selecciona el archivo `GitMiner-L4-1.postman_collection.json` incluido en el proyecto  
5️⃣ Haz clic en **"Import"** 

---

❓ A continuación, se detallan las ayudas sobre los tokens de autenticación, URIs base y parámetros por defecto para las consultas:

---

## 🔧 Configuración · GitHub 🔧

### 📁 Parámetros de configuración

| Parámetro .ENV       | Descripción                           | Ejemplo                             |
|----------------------|---------------------------------------|-------------------------------------|
| `GITHUB_TOKEN`       | Token personal de acceso a GitHub     | `ghp_xxxxxx`                        |
| `GITHUB_BASEURI`     | URL base para las consultas            | `https://api.github.com/repos/`     |

---

### 🔐 Pasos para obtener un Personal Access Token en GitHub

1️⃣ Inicia sesión en [https://github.com/login](https://github.com/login)  
2️⃣ Accede a la configuración de tu perfil (*Settings*)  
3️⃣ Entra en *Developer Settings*  
4️⃣ Selecciona *Personal Access Tokens* → *Tokens (classic)*  
5️⃣ Haz clic en **Generate new token (classic)**  
6️⃣ Configura los detalles del token:
   - **Note**: `GitMiner Token` (o el nombre que desees)
   - **Expiration**: Define la expiración deseada
   - **Permisos**: Marca los permisos necesarios

---

### ⚙️ Parámetros por defecto para GitHub

Estos parámetros controlan el comportamiento por defecto de las consultas a la API:

| Parámetro                            | Descripción                                                                 | Valor por defecto |
|--------------------------------------|-----------------------------------------------------------------------------|-------------------|
| `GITHUB_DEFAULT_SINCE_COMMITS`       | Devuelve los commits de los últimos **X** días                              | 2                 |
| `GITHUB_DEFAULT_SINCE_ISSUES`        | Devuelve las issues actualizados en los últimos **X** días                  | 20                |
| `GITHUB_DEFAULT_MAX_PAGES`           | Número máximo de páginas a iterar                                           | 2                 |

---

## 🔧 Configuración · Bitbucket 🔧

### 📁 Parámetros de configuración

| Parámetro .ENV         | Descripción                                    | Ejemplo                                       |
|------------------------|------------------------------------------------|-----------------------------------------------|
| `BITBUCKET_BASEURI`    | URL base para las consultas a Bitbucket        | `https://api.bitbucket.org/2.0/repositories/` |

---

### ⚙️ Parámetros por defecto para Bitbucket

| Parámetro                                | Descripción                                                 | Valor por defecto |
|------------------------------------------|-------------------------------------------------------------|-------------------|
| `BITBUCKET_DEFAULT_SINCE_COMMITS`        | Devuelve **X** commits por página                           | 5                 |
| `BITBUCKET_DEFAULT_SINCE_ISSUES`         | Devuelve **X** issues por página                            | 5                 |
| `BITBUCKET_DEFAULT_MAX_PAGES`            | Número máximo de páginas a iterar                           | 2                 |


