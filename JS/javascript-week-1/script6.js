const users =  [
    { id: 101, name: "Uday", role: "ADMIN" },
    { id: 102, name: "Rahul", role: "USER" },
    { id: 103, name: "Anil", role: "USER" },
    { id: 104, name: "Priya", role: "ADMIN" }
];

function findUserById(users, userId)
{


    if(!Array.isArray(users))
    {
        return []
    }

    return users.find(
        user => user.id === userId
    ) ?? null;

    



}

console.log(findUserById(users, 999));