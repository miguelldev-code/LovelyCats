# 🐾 LovelyCats

**LovelyCats** es una plataforma web integral diseñada para transformar la experiencia de cuidado felino. Combina un **sistema de adopción**, **servicios veterinarios especializados** y un **e-commerce premium** en una sola aplicación moderna y robusta.

---

## ✨ Características Estelares

### 🏠 Experiencia de Usuario (Frontend)
- **Home Page Dinámica**: 
  - **Carrusel Interactivo** de mascotas esperando hogar.
  - **Servicios Destacados** con acceso directo a soluciones especializadas.
  - Diseño vibrante y responsive.
- **Catálogo Inteligente**:
  - Búsqueda de productos por nombre.
  - Filtrado por categorías.
  - Vistas detalladas con imágenes de alta calidad.
- **Carrito de Compras**: Gestión fluida de productos, cantidades y totales en tiempo real.
- **Centro de Servicios**:
  - Páginas dedicadas para **Veterinaria**, **Hospedaje**, **Spa & Estética** y **Nutrición**.
- **Adopción**:
  - Perfiles completos de mascotas (Edad, Raza, Estado de vacunación).
  - Integración con **WhatsApp** para contacto directo.

### 🛡️ Dashboard Administrativo (Backend)
Un panel de control potente para la gestión total del negocio:
- **Estadísticas en Tiempo Real**: Gráficos interactivos (Chart.js) de actividad y distribución de mascotas.
- **Gestión Total (CRUD)**:
  - **Usuarios**: Crear, editar roles y eliminar cuentas.
  - **Productos**: Administración de inventario, precios e imágenes.
  - **Mascotas**: Control de estados de adopción y fichas médicas.
- **Herramientas Rápidas**: Accesos directos para tareas frecuentes y exportación de reportes.

### 🔐 Seguridad y Acceso
- **Autenticación Robusta**: Login y Registro seguros con Spring Security.
- **Control de Roles**:
  - **ADMIN**: Acceso total al Dashboard (`/admin/**`).
  - **USER**: Acceso a compras, historial y perfil.
  - **Público**: Acceso a catálogo, servicios y adopción.

---

## 🛠️ Stack Tecnológico

### Backend
- **Java 17** (LTS)
- **Spring Boot 3.3.0**
  - **Spring Security** (Auth & Roles)
  - **Spring Data JPA** (Persistencia)
  - **Spring MVC** (Controladores)
- **PostgreSQL** (Base de datos relacional)
- **Hibernate** (ORM)

### Frontend
- **Thymeleaf** (Motor de plantillas server-side)
- **Bootstrap 5** (Diseño responsive y moderno)
- **Bootstrap Icons** (Iconografía vectorial)
- **Chart.js** (Visualización de datos)
- **JavaScript Valilla** (Interactividad cliente)

### Herramientas
- **Maven** (Gestión de dependencias)
- **Git** (Control de versiones)
- **Docker** (Opcional para despliegue)

---

## 📂 Estructura del Proyecto

```
LovelyCats/
├── src/main/java/miguel/lovelycats/
│   ├── config/            # Configuración (Seguridad, DataSeeder)
│   ├── controller/        # Controladores (Admin, Productos, Mascotas)
│   ├── pets/              # Módulo de Mascotas (Entidad, Servicio, Repositorio)
│   ├── products/          # Módulo de Productos
│   ├── userol/            # Módulo de Usuarios y Roles
│   └── ...
├── src/main/resources/
│   ├── static/
│   │   ├── css/           # Estilos personalizados
│   │   ├── js/            # Lógica de gráficos y UI
│   │   └── img/           # Assets estáticos
│   ├── templates/
│   │   ├── admin/         # Vistas protegidas (Dashboard, Tablas CRUD)
│   │   ├── fragments/     # Componentes reutilizables (Navbar, Footer)
│   │   ├── service*.html  # Páginas de servicios
│   │   └── ...
│   └── application.properties
└── pom.xml
```

---

## 🚀 Instalación y Despliegue

### Requisitos
1. **Java JDK 17+**
2. **PostgreSQL** instalado y corriendo.
3. **Maven** instalado.

### Pasos

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/miguelldev/LovelyCats.git
   cd LovelyCats
   ```

2. **Configurar Base de Datos**
   - Crear base de datos: `CREATE DATABASE lovelycats;`
   - Editar `src/main/resources/application.properties`:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/lovelycats
     spring.datasource.username=tu_usuario
     spring.datasource.password=tu_contraseña
     ```

3. **Ejecutar**
   ```bash
   mvn spring-boot:run
   ```

4. **Acceder**
   - Web: [http://localhost:8080](http://localhost:8080)
   - **Credenciales Admin**: `admin@lovelycats.com` / `admin123`

---

## 🔮 Roadmap y Futuro

Hemos completado la **Fase 1 (Core & Gestión)**. Las próximas metas incluyen:

- [x] **Dashboard Administrativo**: Implementado con gráficos y CRUD completo.
- [x] **Catálogo Avanzado**: Búsqueda y filtros implementados.
- [x] **Servicios Especializados**: Páginas informativas desplegadas.
- [ ] **Pasarela de Pagos**: Integración con Stripe/PayPal para checkout real.
- [ ] **Perfil de Usuario Avanzado**: Historial de pedidos y citas veterinarias.
- [ ] **Notificaciones**: Alertas por email para nuevas adopciones.

---

## 🤝 Contribuciones

Este es un proyecto open-source. ¡Toda ayuda es bienvenida!
1. Haz un Fork.
2. Crea tu feature branch (`git checkout -b feature/NuevaCaracteristica`).
3. Haz Commit (`git commit -m 'Añadiendo NuevaCaracteristica'`).
4. Haz Push (`git push origin feature/NuevaCaracteristica`).
5. Abre un Pull Request.

---

## 📄 Licencia

Distribuido bajo la licencia **MIT**. Ver `LICENSE` para más información.

---

**Desarrollado con ❤️ por Miguel Ángel Ortiz Escobar**
