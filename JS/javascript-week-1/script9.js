const users = [
    {
        id: 101,
        name: "Uday",
        role: "ADMIN",
        status: "ACTIVE",
        salary: 85000,
        orders: 5
    },
    {
        id: 102,
        name: "Rahul",
        role: "USER",
        status: "INACTIVE",
        salary: 55000,
        orders: 2
    },
    {
        id: 103,
        name: "Anil",
        role: "USER",
        status: "ACTIVE",
        salary: 65000,
        orders: 8
    },
    {
        id: 104,
        name: "Priya",
        role: "ADMIN",
        status: "BLOCKED",
        salary: 95000,
        orders: 3
    },
    {
        id: 105,
        name: "Kiran",
        role: "USER",
        status: "ACTIVE",
        salary: 70000,
        orders: 10
    },
    {
        id: 106,
        name: "Sneha",
        role: "USER",
        status: "ACTIVE",
        salary: 60000,
        orders: 4
    },
    {
        id: 103,
        name: "Anil Updated",
        role: "USER",
        status: "ACTIVE",
        salary: 68000,
        orders: 9
    },
    {
        id: 107,
        name: "Arjun",
        role: "USER",
        status: "INACTIVE",
        salary: 50000,
        orders: 1
    }
];

function updateUserStatus(users,userId,userStatus)
{
    if(users === null || userId === null || userStatus == null)
    {
        return null;
    }

     for(let user of users)
     {
        if(user.id === userId)
        {
            user.status = userStatus;
            return user;
        }
     }

    

     return "userId not found";
    
}


function removeuserById(users, userId)
{
    if(!Array.isArray(users) || !userId)
    {
        return null;
    }

    
    return users.filter(user => user.id !== userId);

}

function highestPaidUser(users)
{
    if(!Array.isArray(users))
    {
        return null;
    }

    let highestUser = users[0];

    for(let user of users)
    {
        if(user.salary > highestUser.salary)
        {
            highestUser = user;
        }
    }

    
    return highestUser;

}

function calculateTotalOrders(users) {
    // your logic

    if(!Array.isArray(users))
    {
        return null;
    }

    let totalOrders = 0;
    for(let user of users)
    {
        totalOrders += user.orders;
    }

    return totalOrders;
}

//console.log(updateUserStatus(users, 102, "ACTIVE"));

//console.log(removeuserById(users, 104));

console.log(calculateTotalOrders(users));

