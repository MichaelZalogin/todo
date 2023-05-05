$('#taskEditDialog').on('shown.bs.modal', function (event) {
    let button = $(event.relatedTarget) // Button that triggered the modal
    let taskId = button.data('taskid') // Extract info from data-* attributes

    if (taskId) {
        $.get({
            url: '/tasks/' + taskId,
            success: (data) => {
                let modal = $(this)
                modal.find('#task-id').val(data.id)
                modal.find('#task-name').val(data.name)
                modal.find('#task-description').val(data.description)
            },
            error: (err) => {
                alert(err);
            }
        });
    }
})

$('#delete-task-button').on('click', function () {
    let modal = $('#taskEditDialog');
    let taskId = modal.find('#task-id').val();
    $.get({
        url: 'tasks/delete/' + taskId,
        success: () => {
            location.reload();
        },
        error: (err) => {
            alert(err);
        }
    });
    modal.modal('hide');
});

$('#save-task-button').on('click', function () {
    let modal = $('#taskEditDialog')
    let task = {
        name: modal.find('#task-name').val(),
        description: modal.find('#task-description').val(),
    };
    if (modal.find('#task-id').val()) {
        task.id = modal.find('#task-id').val()
    }
    $.ajax({
        url: '/tasks/update',
        type: 'POST',
        data: JSON.stringify(task),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: () => {
            location.reload();
        },
        error: (err) => {
            location.reload();
        }
    })
    modal.modal('hide');
});

$('.close-modal').click(function () {
    let modal = $('#taskEditDialog');
    modal.modal('hide');
});

$(document).ready(function () {
    $('.chosen-select').chosen();
});