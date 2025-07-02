# API Documentation for Loam System

This document provides a comprehensive overview of the RESTful APIs available in the Loam System. It is designed to be consumed by an AI for generating frontend interfaces.

## Base URL
`/` (relative to the application's root)

## Common Response Structures

### Message
Represents a general API response, typically for operations that don't return specific data.

| Field   | Type   | Description                               |
| :------ | :----- | :---------------------------------------- |
| `message` | `string` | A human-readable message about the operation's outcome. |
| `code`    | `integer` | An integer status code (e.g., 200 for success, 500 for error). |

**Example Success Response:**
```json
{
  "message": "Success",
  "code": 200
}
```

**Example Error Response:**
```json
{
  "message": "Error occurred",
  "code": 500
}
```

### DataSet<T>
Extends `Message` and includes a `data` field for responses that return specific data.

| Field   | Type   | Description                               |
| :------ | :----- | :---------------------------------------- |
| `message` | `string` | A human-readable message about the operation's outcome. |
| `code`    | `integer` | An integer status code (e.g., 200 for success, 500 for error). |
| `data`    | `T`      | The actual data payload of the response. The type `T` varies based on the endpoint. |

**Example Success Response (with data):**
```json
{
  "message": "Success",
  "code": 200,
  "data": {
    // ... entity data ...
  }
}
```

## Entities

### User Entity
| Field        | Type      | Description                               |
| :----------- | :-------- | :---------------------------------------- |
| `id`         | `Long`    | Unique identifier for the user.           |
| `account`    | `String`  | User's account name.                      |
| `name`       | `String`  | User's full name.                         |
| `password`   | `String`  | User's password.                          |
| `sex`        | `String`  | User's sex.                               |
| `phone`      | `String`  | User's phone number.                      |
| `email`      | `String`  | User's email address.                     |
| `delFlag`    | `Integer` | Deletion flag (0 for active, 1 for deleted). |
| `creator`    | `String`  | User who created the record.              |
| `createTime` | `LocalDateTime` | Timestamp of record creation.             |
| `lastModifier` | `String`  | User who last modified the record.        |
| `lastModifyTime` | `LocalDateTime` | Timestamp of last modification.           |
| `remark`     | `String`  | Additional remarks.                       |

#### User API Endpoints

##### Get User by ID
- **HTTP Method:** `GET`
- **Path:** `/user/{id}`
- **Description:** Retrieves a single user by their ID.
- **Path Parameters:**
    | Name | Type    | Description      |
    | :--- | :------ | :--------------- |
    | `id` | `integer` | The ID of the user to retrieve. |
- **Response:** `DataSet<User>`

##### Get User List
- **HTTP Method:** `GET`
- **Path:** `/user/list`
- **Description:** Retrieves a list of users, optionally filtered by provided criteria.
- **Query Parameters:**
    | Name      | Type     | Description                               |
    | :-------- | :------- | :---------------------------------------- |
    | `account` | `string` | Filter by user account.                   |
    | `name`    | `string` | Filter by user name (partial match).      |
    | `phone`   | `string` | Filter by user phone number.              |
- **Response:** `DataSet<List<User>>`

##### Get User List by Page
- **HTTP Method:** `GET`
- **Path:** `/user/listByPage`
- **Description:** Retrieves a paginated list of users, optionally filtered by provided criteria.
- **Query Parameters:**
    | Name      | Type     | Description                               |
    | :-------- | :------- | :---------------------------------------- |
    | `account` | `string` | Filter by user account.                   |
    | `name`    | `string` | Filter by user name (partial match).      |
    | `phone`   | `string` | Filter by user phone number.              |
    | `pageNum` | `integer` | Page number (default: 1).                 |
    | `pageSize`| `integer` | Number of items per page (default: 10).   |
- **Response:** `DataSet<List<User>>`

##### Create User
- **HTTP Method:** `POST`
- **Path:** `/user`
- **Description:** Creates a new user.
- **Request Body:** `User` object (excluding `id`, `delFlag`, `creator`, `createTime`, `lastModifier`, `lastModifyTime`, `remark` as they are typically set by the system).
- **Response:** `DataSet<User>` (the created user object with system-generated fields)

##### Update User
- **HTTP Method:** `PUT`
- **Path:** `/user`
- **Description:** Updates an existing user.
- **Request Body:** `User` object (must include `id` of the user to update).
- **Response:** `DataSet<User>` (the updated user object)

##### Delete User
- **HTTP Method:** `DELETE`
- **Path:** `/user/{id}`
- **Description:** Logically deletes a user by setting their `delFlag` to 1.
- **Path Parameters:**
    | Name | Type    | Description      |
    | :--- | :------ | :--------------- |
    | `id` | `integer` | The ID of the user to delete. |
- **Response:** `Message`

### Role Entity
| Field        | Type      | Description                               |
| :----------- | :-------- | :---------------------------------------- |
| `id`         | `Long`    | Unique identifier for the role.           |
| `name`       | `String`  | Role name.                                |
| `roleKey`    | `String`  | Unique key for the role.                  |
| `status`     | `Integer` | Role status.                              |
| `orderNum`   | `Integer` | Order number for display.                 |
| `delFlag`    | `Integer` | Deletion flag (0 for active, 1 for deleted). |
| `creator`    | `String`  | User who created the record.              |
| `createTime` | `LocalDateTime` | Timestamp of record creation.             |
| `lastModifier` | `String`  | User who last modified the record.        |
| `lastModifyTime` | `LocalDateTime` | Timestamp of last modification.           |
| `remark`     | `String`  | Additional remarks.                       |

#### Role API Endpoints

##### Get Role by ID
- **HTTP Method:** `GET`
- **Path:** `/role/{id}`
- **Description:** Retrieves a single role by its ID.
- **Path Parameters:**
    | Name | Type    | Description      |
    | :--- | :------ | :--------------- |
    | `id` | `integer` | The ID of the role to retrieve. |
- **Response:** `DataSet<Role>`

##### Get Role List
- **HTTP Method:** `GET`
- **Path:** `/role/list`
- **Description:** Retrieves a list of roles, optionally filtered by provided criteria.
- **Query Parameters:**
    | Name      | Type     | Description                               |
    | :-------- | :------- | :---------------------------------------- |
    | `name`    | `string` | Filter by role name (partial match).      |
    | `roleKey` | `string` | Filter by role key.                       |
    | `status`  | `integer` | Filter by role status.                    |
- **Response:** `DataSet<List<Role>>`

##### Get Role List by Page
- **HTTP Method:** `GET`
- **Path:** `/role/listByPage`
- **Description:** Retrieves a paginated list of roles, optionally filtered by provided criteria.
- **Query Parameters:**
    | Name      | Type     | Description                               |
    | :-------- | :------- | :---------------------------------------- |
    | `name`    | `string` | Filter by role name (partial match).      |
    | `roleKey` | `string` | Filter by role key.                       |
    | `status`  | `integer` | Filter by role status.                    |
    | `pageNum` | `integer` | Page number (default: 1).                 |
    | `pageSize`| `integer` | Number of items per page (default: 10).   |
- **Response:** `DataSet<List<Role>>`

##### Get Role List by Page
- **HTTP Method:** `GET`
- **Path:** `/role/listByPage`
- **Description:** Retrieves a paginated list of roles, optionally filtered by provided criteria.
- **Query Parameters:
    | Name      | Type     | Description                               |
    | :-------- | :------- | :---------------------------------------- |
    | `name`    | `string` | Filter by role name (partial match).      |
    | `roleKey` | `string` | Filter by role key.                       |
    | `status`  | `integer` | Filter by role status.                    |
    | `pageNum` | `integer` | Page number (default: 1).                 |
    | `pageSize`| `integer` | Number of items per page (default: 10).   |
- **Response:** `DataSet<List<Role>>`

##### Get Role List by Page
- **HTTP Method:** `GET`
- **Path:** `/role/listByPage`
- **Description:** Retrieves a paginated list of roles, optionally filtered by provided criteria.
- **Query Parameters:**
    | Name      | Type     | Description                               |
    | :-------- | :------- | :---------------------------------------- |
    | `name`    | `string` | Filter by role name (partial match).      |
    | `roleKey` | `string` | Filter by role key.                       |
    | `status`  | `integer` | Filter by role status.                    |
    | `pageNum` | `integer` | Page number (default: 1).                 |
    | `pageSize`| `integer` | Number of items per page (default: 10).   |
- **Response:** `DataSet<List<Role>>`

##### Get Role List by Page
- **HTTP Method:** `GET`
- **Path:** `/role/listByPage`
- **Description:** Retrieves a paginated list of roles, optionally filtered by provided criteria.
- **Query Parameters:**
    | Name      | Type     | Description                               |
    | :-------- | :------- | :---------------------------------------- |
    | `name`    | `string` | Filter by role name (partial match).      |
    | `roleKey` | `string` | Filter by role key.                       |
    | `status`  | `integer` | Filter by role status.                    |
    | `pageNum` | `integer` | Page number (default: 1).                 |
    | `pageSize`| `integer` | Number of items per page (default: 10).   |
- **Response:** `DataSet<List<Role>>`

##### Get Role List by Page
- **HTTP Method:** `GET`
- **Path:** `/role/listByPage`
- **Description:** Retrieves a paginated list of roles, optionally filtered by provided criteria.
- **Query Parameters:**
    | Name      | Type     | Description                               |
    | :-------- | :------- | :---------------------------------------- |
    | `name`    | `string` | Filter by role name (partial match).      |
    | `roleKey` | `string` | Filter by role key.                       |
    | `status`  | `integer` | Filter by role status.                    |
    | `pageNum` | `integer` | Page number (default: 1).                 |
    | `pageSize`| `integer` | Number of items per page (default: 10).   |
- **Response:** `DataSet<List<Role>>`

##### Get Role List by Page
- **HTTP Method:** `GET`
- **Path:** `/role/listByPage`
- **Description:** Retrieves a paginated list of roles, optionally filtered by provided criteria.
- **Query Parameters:**
    | Name      | Type     | Description                               |
    | :-------- | :------- | :---------------------------------------- |
    | `name`    | `string` | Filter by role name (partial match).      |
    | `roleKey` | `string` | Filter by role key.                       |
    | `status`  | `integer` | Filter by role status.                    |
    | `pageNum` | `integer` | Page number (default: 1).                 |
    | `pageSize`| `integer` | Number of items per page (default: 10).   |
- **Response:** `DataSet<List<Role>>`

##### Create Role
- **HTTP Method:** `POST`
- **Path:** `/role`
- **Description:** Creates a new role.
- **Request Body:** `Role` object.
- **Response:** `DataSet<Role>`

##### Update Role
- **HTTP Method:** `PUT`
- **Path:** `/role`
- **Description:** Updates an existing role.
- **Request Body:** `Role` object (must include `id`).
- **Response:** `DataSet<Role>`

##### Delete Role
- **HTTP Method:** `DELETE`
- **Path:** `/role/{id}`
- **Description:** Logically deletes a role.
- **Path Parameters:**
    | Name | Type    | Description      |
    | :--- | :------ | :--------------- |
    | `id` | `integer` | The ID of the role to delete. |
- **Response:** `Message`

### Department Entity
| Field        | Type      | Description                               |
| :----------- | :-------- | :---------------------------------------- |
| `id`         | `Long`    | Unique identifier for the department.     |
| `name`       | `String`  | Department name.                          |
| `code`       | `String`  | Department code.                          |
| `phone`      | `String`  | Department phone number.                  |
| `email`      | `String`  | Department email address.                 |
| `orderNum`   | `Integer` | Order number for display.                 |
| `delFlag`    | `Integer` | Deletion flag (0 for active, 1 for deleted). |
| `creator`    | `String`  | User who created the record.              |
| `createTime` | `LocalDateTime` | Timestamp of record creation.             |
| `lastModifier` | `String`  | User who last modified the record.        |
| `lastModifyTime` | `LocalDateTime` | Timestamp of last modification.           |
| `remark`     | `String`  | Additional remarks.                       |

#### Department API Endpoints

##### Get Department by ID
- **HTTP Method:** `GET`
- **Path:** `/department/{id}`
- **Description:** Retrieves a single department by its ID.
- **Path Parameters:**
    | Name | Type    | Description      |
    | :--- | :------ | :--------------- |
    | `id` | `integer` | The ID of the department to retrieve. |
- **Response:** `DataSet<Department>`

##### Get Department List
- **HTTP Method:** `GET`
- **Path:** `/department/list`
- **Description:** Retrieves a list of departments, optionally filtered by provided criteria.
- **Query Parameters:**
    | Name   | Type     | Description                               |
    | :----- | :------- | :---------------------------------------- |
    | `name` | `string` | Filter by department name (partial match). |
    | `code` | `string` | Filter by department code.                |
- **Response:** `DataSet<List<Department>>`

##### Get Department List by Page
- **HTTP Method:** `GET`
- **Path:** `/department/listByPage`
- **Description:** Retrieves a paginated list of departments, optionally filtered by provided criteria.
- **Query Parameters:**
    | Name   | Type     | Description                               |
    | :----- | :------- | :---------------------------------------- |
    | `name` | `string` | Filter by department name (partial match). |
    | `code` | `string` | Filter by department code.                |
    | `pageNum` | `integer` | Page number (default: 1).                 |
    | `pageSize`| `integer` | Number of items per page (default: 10).   |
- **Response:** `DataSet<List<Department>>`

##### Create Department
- **HTTP Method:** `POST`
- **Path:** `/department`
- **Description:** Creates a new department.
- **Request Body:** `Department` object.
- **Response:** `DataSet<Department>`

##### Update Department
- **HTTP Method:** `PUT`
- **Path:** `/department`
- **Description:** Updates an existing department.
- **Request Body:** `Department` object (must include `id`).
- **Response:** `DataSet<Department>`

##### Delete Department
- **HTTP Method:** `DELETE`
- **Path:** `/department/{id}`
- **Description:** Logically deletes a department.
- **Path Parameters:**
    | Name | Type    | Description      |
    | :--- | :------ | :--------------- |
    | `id` | `integer` | The ID of the department to delete. |
- **Response:** `Message`

### Post Entity
| Field        | Type      | Description                               |
| :----------- | :-------- | :---------------------------------------- |
| `id`         | `Long`    | Unique identifier for the post.           |
| `name`       | `String`  | Post name.                                |
| `code`       | `String`  | Post code.                                |
| `responsibility` | `String`  | Post responsibility.                      |
| `departId`   | `Long`    | ID of the associated department.          |
| `delFlag`    | `Integer` | Deletion flag (0 for active, 1 for deleted). |
| `creator`    | `String`  | User who created the record.              |
| `createTime` | `LocalDateTime` | Timestamp of record creation.             |
| `lastModifier` | `String`  | User who last modified the record.        |
| `lastModifyTime` | `LocalDateTime` | Timestamp of last modification.           |
| `remark`     | `String`  | Additional remarks.                       |

#### Post API Endpoints

##### Get Post by ID
- **HTTP Method:** `GET`
- **Path:** `/post/{id}`
- **Description:** Retrieves a single post by its ID.
- **Path Parameters:**
    | Name | Type    | Description      |
    | :--- | :------ | :--------------- |
    | `id` | `integer` | The ID of the post to retrieve. |
- **Response:** `DataSet<Post>`

##### Get Post List
- **HTTP Method:** `GET`
- **Path:** `/post/list`
- **Description:** Retrieves a list of posts, optionally filtered by provided criteria.
- **Query Parameters:**
    | Name       | Type     | Description                               |
    | :--------- | :------- | :---------------------------------------- |
    | `name`     | `string` | Filter by post name (partial match).      |
    | `code`     | `string` | Filter by post code.                      |
    | `departId` | `Long`   | Filter by associated department ID.       |
- **Response:** `DataSet<List<Post>>`

##### Get Post List by Page
- **HTTP Method:** `GET`
- **Path:** `/post/listByPage`
- **Description:** Retrieves a paginated list of posts, optionally filtered by provided criteria.
- **Query Parameters:**
    | Name       | Type     | Description                               |
    | :--------- | :------- | :---------------------------------------- |
    | `name`     | `string` | Filter by post name (partial match).      |
    | `code`     | `string` | Filter by post code.                      |
    | `departId` | `Long`   | Filter by associated department ID.       |
    | `pageNum`  | `integer` | Page number (default: 1).                 |
    | `pageSize` | `integer` | Number of items per page (default: 10).   |
- **Response:** `DataSet<List<Post>>`

##### Create Post
- **HTTP Method:** `POST`
- **Path:** `/post`
- **Description:** Creates a new post.
- **Request Body:** `Post` object.
- **Response:** `DataSet<Post>`

##### Update Post
- **HTTP Method:** `PUT`
- **Path:** `/post`
- **Description:** Updates an existing post.
- **Request Body:** `Post` object (must include `id`).
- **Response:** `DataSet<Post>`

##### Delete Post
- **HTTP Method:** `DELETE`
- **Path:** `/post/{id}`
- **Description:** Logically deletes a post.
- **Path Parameters:**
    | Name | Type    | Description      |
    | :--- | :------ | :--------------- |
    | `id` | `integer` | The ID of the post to delete. |
- **Response:** `Message`

### Menu Entity
| Field        | Type      | Description                               |
| :----------- | :-------- | :---------------------------------------- |
| `id`         | `Long`    | Unique identifier for the menu.           |
| `name`       | `String`  | Menu name.                                |
| `type`       | `Integer` | Menu type.                                |
| `status`     | `Integer` | Menu status.                              |
| `disable`    | `Integer` | Disable flag.                             |
| `orderNum`   | `Integer` | Order number for display.                 |
| `parentId`   | `Long`    | ID of the parent menu (for hierarchical menus). |
| `delFlag`    | `Integer` | Deletion flag (0 for active, 1 for deleted). |
| `creator`    | `String`  | User who created the record.              |
| `createTime` | `LocalDateTime` | Timestamp of record creation.             |
| `lastModifier` | `String`  | User who last modified the record.        |
| `lastModifyTime` | `LocalDateTime` | Timestamp of last modification.           |
| `remark`     | `String`  | Additional remarks.                       |

#### Menu API Endpoints

##### Get Menu by ID
- **HTTP Method:** `GET`
- **Path:** `/menu/{id}`
- **Description:** Retrieves a single menu by its ID.
- **Path Parameters:**
    | Name | Type    | Description      |
    | :--- | :------ | :--------------- |
    | `id` | `integer` | The ID of the menu to retrieve. |
- **Response:** `DataSet<Menu>`

##### Get Menu List
- **HTTP Method:** `GET`
- **Path:** `/menu/list`
- **Description:** Retrieves a list of menus, optionally filtered by provided criteria.
- **Query Parameters:**
    | Name     | Type     | Description                               |
    | :------- | :------- | :---------------------------------------- |
    | `name`   | `string` | Filter by menu name (partial match).      |
    | `type`   | `integer` | Filter by menu type.                      |
    | `status` | `integer` | Filter by menu status.                    |
    | `disable`| `integer` | Filter by disable flag.                   |
- **Response:** `DataSet<List<Menu>>`

##### Create Menu
- **HTTP Method:** `POST`
- **Path:** `/menu`
- **Description:** Creates a new menu.
- **Request Body:** `Menu` object.
- **Response:** `DataSet<Menu>`

##### Update Menu
- **HTTP Method:** `PUT`
- **Path:** `/menu`
- **Description:** Updates an existing menu.
- **Request Body:** `Menu` object (must include `id`).
- **Response:** `DataSet<Menu>`

##### Delete Menu
- **HTTP Method:** `DELETE`
- **Path:** `/menu/{id}`
- **Description:** Logically deletes a menu.
- **Path Parameters:**
    | Name | Type    | Description      |
    | :--- | :------ | :--------------- |
    | `id` | `integer` | The ID of the menu to delete. |
- **Response:** `Message`