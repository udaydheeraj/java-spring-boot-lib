const users = [
    { id: 1, name: "Uday", active: true },
    { id: 2, name: "Rahul", active: false },
    { id: 3, name: "Anil", active: true },
    { id: 4, name: "Priya", active: true }
];

function getActiveUsers(users)
{
    
    if(!Array.isArray(users))
    {
        return []
    }
    return users.map(
        user => user.name
    )
    
}
const activeUsers = getActiveUsers(users);

console.log(getActiveUsers(null));

