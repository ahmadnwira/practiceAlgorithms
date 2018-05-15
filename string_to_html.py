def string_to_html(content_list):
    """function return html repsentation of input.
    Args:
        content_list (str): List of strings
    Returns:
        str: html uordered list representation of the input
    >>> string_to_html(['Apple', 'Apricot', 'Pomegranate'])
    '<ul><li> Apple </li><li> Apricot </li><li> Pomegranate </li></ul>'
    >>> string_to_html([])
    '<ul><li> no content available </li></ul>'
    >>> string_to_html(45)
    'input must be list'
    """
    if not isinstance(content_list, list):
        return 'input must be list'

    rv = '<ul>'
    if len(content_list) < 1:
        rv += '<li> no content available </li>'

    else:
        for item in content_list:
            rv += '<li> %s </li>' % item

    rv += '</ul>'

    return rv
