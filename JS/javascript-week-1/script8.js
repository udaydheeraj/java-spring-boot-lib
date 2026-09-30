const users = [
    { id: 1, name: "Uday", status: "INACTIVE" },
    { id: 2, name: "Rahul", status: "ACTIVE" },
    { id: 3, name: "Anil", status: "ACTIVE" },
    { id: 4, name: "Priya", status: "BLOCKED" }
];

function findFirstUserByStatus(users, status)
{

    if(!Array.isArray(users) || !status){
        return null;
    }

    for(let user of users)
    {
        if(user.status === status)
        {
            return user;
        }
    }

    return null;
}

const activeUser = findFirstUserByStatus(users, null)

console.log(activeUser)