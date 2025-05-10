# ⚙️ **GitMiner Configuration** ⚙️

Bienvenido a la configuración de **GitMiner**, que no es más que una herramienta de minería de repositorios Git (información de repositorios, tales como cargar, procesar y analizar datos de proyectos) en ***GitHub*** y ***Bitbucket*** mediante sus APIs. 

❓· Vamos a introducir una ayuda dentro de los tokens de autenticación, URIs base y parámetros por defecto para las consultas de los Commits e Issues.

----

## 🔧 Configuración · GitHub 🔧 

· En primer lugar, deberemos de configurar los parámetros de nuestro archivo *.ENV*
❗** ¡OJO! ** → El archivo del proyecto hay que copiarlo y modificarlo de la siguiente manera: .ENV.EXAMPLE → .ENV

· Para autenticarte con la API de **GitHub**, necesitas un token personal válido.

| Parámetro .ENV                  | Descripción                         | Ejemplo                            |
|---------------------------------|-------------------------------------|------------------------------------|
| `GITHUB_TOKEN`                  | Token personal de acceso a GitHub   | =ghp_xxxxxx                        |
| `GITHUB_BASEURI`                | URL base para las consultas         | =https://api.github.com/repos/     |   |---------------------------------|-------------------------------------|------------------------------------|


· 🔐 **PASOS PARA OBTENER UN TOKEN (Personal Access Token) DE GITHUB** 🔐

  1️⃣ Iniciar sesión en GitHub : [https://github.com/login](https://github.com/login)

  2️⃣ Accede a la configuración de tu perfil una vez iniciada la sesión *(Settings)*
  
  3️⃣ Entra a *Developer Settings*  
  
  4️⃣ Selecciona  *Personal Access Tokens* → *Tokens (classic)*  
  
  5️⃣ **Genera un nuevo Token** (Generate new token (classic))
  
  6️⃣ **Configuración de los detalles del tokenc:**
     - **Note** : Describe el uso del token (en este caso, por ejemplo : `GitMiner Token`)
     - **Expiration** : Selecciona una expiración).
     - **Permisos**: Marca los permisos que sean necesarios.  
  
  7️⃣ Genera y guarda tu token en un lugar seguro

---


