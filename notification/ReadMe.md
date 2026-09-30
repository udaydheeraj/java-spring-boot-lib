notification
│
├── controller
├── service
│   └── impl
├── repository
│   ├── UserRepository.java
│   └── NotificationRepository.java
├── entity
├── dto
│   ├── request
│   └── response
├── exception
└── mapper

__________________________________________________________





┌──────────────────────────────────────────────┐
│ NotificationRepository                       │
├──────────────────────────────────────────────┤
│ findByUser_Id(...)                           │
│ findByUser_IdAndStatus(...)                  │
│ countByUser_IdAndStatus(...)                 │
│ findByUser_IdAndType(...)                    │
│ findById(...)       ← JpaRepository          │
│ save(...)           ← JpaRepository          │
│ delete(...)         ← JpaRepository          │
└──────────────────────────────────────────────┘

_________________________________________________________________

phase 4:

dto
├── request
│   └── CreateNotificationRequest
│
└── response
└── NotificationResponse

mapper
└── NotificationMapper

----------------------------------------------------
notification
│
├── controller
│
├── service
│   └── impl
│
├── repository
│
├── entity
│
├── dto
│   ├── request
│   │   └── CreateNotificationRequest
│   │
│   └── response
│       ├── NotificationResponse
│       └── ErrorResponse
│
├── mapper
│   └── NotificationMapper
│
└── exception
├── UserNotFoundException
├── NotificationNotFoundException
├── NotificationAccessDeniedException
└── GlobalExceptionHandler

---------------------------------------------------

                    HTTP
                     │
                     ▼
              NotificationController
                     │
              @Valid / parameters
                     │
                     ▼
             NotificationService
                     │
                     ▼
          NotificationServiceImpl
                     │
          ┌──────────┴──────────┐
          ▼                     ▼
UserRepository      NotificationRepository
│                     │
└──────────┬──────────┘
▼
MySQL