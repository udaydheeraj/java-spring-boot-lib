const users = [
    { id: 1, name: "Uday", role: "ADMIN" },
    { id: 2, name: "Rahul", role: "USER" },
    { id: 3, name: "Anil", role: "USER" },
    { id: 4, name: "Priya", role: "ADMIN" },
    { id: 5, name: "Kiran", role: "USER" }
];

function countUsersByRole(users, userRole)
{
    if(!Array.isArray(users))
    {
        return 0;
    }
    let count = 0;
    users.forEach(
        user => {
            if(user.role === userRole) 
                count++ 
        }
    )

    return count
}

const totalCount = countUsersByRole(users, null);

console.log(totalCount);