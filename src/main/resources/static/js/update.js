$(document).ready(
    function() {
        $('#editModal').on('show.bs.modal', function (event) {
            var elementId = $(event.relatedTarget).data('id');
            var elementFirstName = $(event.relatedTarget).data('first');
            var elementLastName = $(event.relatedTarget).data('last');
            var elementEmail = $(event.relatedTarget).data('email');
            console.log(elementId);
            console.log(elementFirstName);
            $("#id").val(elementId);
            $("#first").val(elementFirstName);
            $("#last").val(elementLastName);
            $("#email").val(elementEmail);
        });
    }
);

