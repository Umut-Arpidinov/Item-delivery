function showDescription(element) {
    var description = $(element).text();
    $('body').append('<div class="modal"><p>' + description + '</p></div>');
    $('.modal').click(function() {
        $(this).remove();
    });
}
 function makeText() {
    const lorem = 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatum veritatis eaque necessitatibus, explicabo vero hic, perspiciatis unde minus error consectetur, quos sunt officiis ad repellendus pariatur eligendi tempora praesentium tenetur';
    const loremArray = lorem.split(' ');
    const amountOfText = Math.floor(Math.random() * (30 - 10) + 10);
    const text = loremArray.slice(0, amountOfText);
     return text.join(' ') + '.';
     }