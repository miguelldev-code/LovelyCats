# 🐾 LovelyCats

**LovelyCats** es una plataforma web moderna e integrada para **adopción de mascotas**, **servicios veterinarios** y **e-commerce de productos para gatos**. Centraliza todo lo necesario para el bienestar felino en una experiencia de usuario premium y dinámica.

---

## ✨ Características Principales

### 🏠 Página de Inicio Dinámica
- **Hero Section** con llamadas a la acción claras
- **Productos Destacados** (primeros 4 del catálogo)
- **Mascotas en Adopción** (últimas 4 disponibles)
- **Servicios Veterinarios** con bloques informativos
- **Ofertas Especiales** para adopciones

### 🛍️ E-Commerce de Productos
- Catálogo completo de productos para gatos
- Vista detallada de cada producto
- Sistema de carrito de compras
- Gestión de productos (Admin)

### 🐱 Sistema de Adopción
- Listado de mascotas disponibles
- Información detallada (edad, género, descripción)
- Gestión de mascotas (Admin)

### 👤 Gestión de Usuarios
- Registro e inicio de sesión
- **Perfil de Usuario** con foto y edición de datos
- Control de roles (USER, ADMIN)
- Panel de administración

### 🌐 Internacionalización
- Soporte multiidioma (Español/English)
- Cambio dinámico desde el navbar

### 🎨 UI/UX Premium
- Navbar moderno con iconos y diseño sticky
- Diseño responsive (mobile-first)
- Animaciones y transiciones suaves
- Paleta de colores profesional

---

## 🛠️ Stack Tecnológico

### Backend
- **Java 17**
- **Spring Boot 3.3.0**
  - Spring MVC
  - Spring Security
  - Spring Data JPA
- **Hibernate** (ORM)
- **Lombok** (reducción de boilerplate)
- **Jakarta Validation**

### Frontend
- **Thymeleaf** (template engine)
- **Bootstrap 5** (framework CSS)
- **Bootstrap Icons**
- **JavaScript** (vanilla + interactividad)

### Base de Datos
- **PostgreSQL** (desarrollo)
- **H2** (testing - opcional)
- Esquema:
  - `app_users` (usuarios)
  - `app_roles` (roles)
  - `app_users_roles` (relación many-to-many)
  - `productos` (productos)
  - `pet` (mascotas)
  - `cart_items` (carrito)

### Seguridad
- **Spring Security** con autenticación basada en formularios
- Encriptación de contraseñas (BCrypt)
- Protección CSRF
- Control de acceso por roles

### Herramientas
- **Maven** (gestión de dependencias)
- **Git** (control de versiones)

---

## 📂 Estructura del Proyecto

```
LovelyCats/
├── src/main/java/miguel/lovelycats/
│   ├── cart/              # Carrito de compras
│   ├── config/            # Configuración (DataSeeder, LocaleConfig)
│   ├── controller/        # Controladores (Welcome, Profile)
│   ├── pets/              # Entidades y lógica de mascotas
│   ├── products/          # Entidades y lógica de productos
│   ├── security/          # Configuración de seguridad
│   ├── service/           # Servicios (UploadFileService)
│   └── userol/            # Usuarios y roles
├── src/main/resources/
│   ├── static/
│   │   ├── css/           # Estilos (Bootstrap + custom)
│   │   ├── img/           # Imágenes estáticas
│   │   └── js/            # Scripts
│   ├── templates/         # Plantillas Thymeleaf
│   │   ├── fragments/     # Layout, navbar, footer
│   │   ├── welcome.html   # Página de inicio
│   │   ├── products.html  # Catálogo
│   │   ├── adopt.html     # Adopción
│   │   ├── profile.html   # Perfil de usuario
│   │   └── ...
│   └── application.properties
├── uploads/               # Imágenes subidas (productos, usuarios)
└── pom.xml
```

---

## 🚀 Instalación y Ejecución

### Requisitos Previos
- **Java JDK 17+**
- **Maven 3.6+**
- **PostgreSQL 12+**
- IDE recomendado: **IntelliJ IDEA** o **VS Code**

### Pasos

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/miguelldev/LovelyCats.git
   cd LovelyCats
   ```

2. **Configurar la base de datos**
   - Crear una base de datos en PostgreSQL:
     ```sql
     CREATE DATABASE lovelycats;
     ```
   - Actualizar `src/main/resources/application.properties`:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/lovelycats
     spring.datasource.username=tu_usuario
     spring.datasource.password=tu_contraseña
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Compilar el proyecto**
   ```bash
   mvn clean package -DskipTests
   ```

4. **Ejecutar la aplicación**
   ```bash
   java -jar target/LovelyCats-0.0.1-SNAPSHOT.jar
   ```
   O desde el IDE: ejecutar `LovelyCatsApplication.java`

5. **Acceder a la aplicación**
   - URL: [http://localhost:8080](http://localhost:8080)
   - **Usuario Admin por defecto:**
     - Email: `admin@lovelycats.com`
     - Contraseña: `admin123`

---

## 📊 Datos de Prueba (Seeding)

Al iniciar la aplicación por primera vez, el `DataSeeder` automáticamente crea:
- **1 usuario admin** (`admin@lovelycats.com`)
- **10 productos** (Comida Premium, Rascador, Juguetes, etc.)
- **6 mascotas** (Michi, Luna, Simba, Nala, Garfield, Pelusa)

---

## 🎯 Funcionalidades Implementadas

### ✅ Autenticación y Autorización
- [x] Registro de usuarios
- [x] Login/Logout
- [x] Control de roles (USER, ADMIN)
- [x] Perfil de usuario con foto

### ✅ Gestión de Productos
- [x] Listado de productos
- [x] Vista detallada de producto
- [x] Formulario de agregar producto (Admin)
- [x] Carga de imágenes

### ✅ Gestión de Mascotas
- [x] Listado de mascotas en adopción
- [x] Información detallada
- [x] Formulario de agregar mascota (Admin)

### ✅ Carrito de Compras
- [x] Agregar productos al carrito
- [x] Vista del carrito
- [x] Persistencia por sesión

### ✅ UI/UX
- [x] Navbar moderno con iconos
- [x] Página de inicio dinámica
- [x] Diseño responsive
- [x] Internacionalización (ES/EN)

---

## 🔮 Roadmap - Próximas Mejoras

### 🔹 Corto Plazo
- [ ] **Checkout y Pagos**: Integración con pasarelas (Stripe, PayPal)
- [ ] **Historial de Pedidos**: Panel de usuario con compras anteriores
- [ ] **Búsqueda y Filtros**: Filtrar productos por precio, categoría
- [ ] **Wishlist**: Lista de deseos para productos
- [ ] **Notificaciones**: Sistema de alertas para adopciones

### 🔹 Mediano Plazo
- [ ] **Sistema de Reseñas**: Comentarios y valoraciones de productos
- [ ] **Chat en Vivo**: Soporte al cliente en tiempo real
- [ ] **Blog/Noticias**: Sección de contenido educativo
- [ ] **API REST**: Endpoints públicos para integraciones
- [ ] **Panel de Analytics**: Dashboard para administradores

### 🔹 Largo Plazo
- [ ] **Microservicios**: Migración a arquitectura de microservicios
- [ ] **Aplicación Móvil**: App nativa (React Native/Flutter)
- [ ] **IA para Recomendaciones**: Sugerencias personalizadas de productos
- [ ] **Sistema de Donaciones**: Apoyo a refugios de animales
- [ ] **Marketplace**: Permitir vendedores externos

---

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Por favor:
1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

---

## 📄 Licencia

Este proyecto es de código abierto bajo la licencia MIT.

---

## 👨‍💻 Autor

**Miguel Ángel Ortiz Escobar** - [@miguelldev](https://github.com/miguelldev)



---

**¡Gracias por usar LovelyCats! 🐱💚**
