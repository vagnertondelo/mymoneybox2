const accounts = 'dashboard/getaccount';

$(document).ready(function() {
    getAccount()
});

function getAccount() {
    return fetch(accounts)
        .then(response => response.json())
        .catch((obj) => {
            Swal.insertQueueStep({
                type: 'error',
                title: 'erro'
            })
            return false;
        }).then(a => {
            $("#indicar").val($("#indicar").val() + a.accountNo)
        })
}


