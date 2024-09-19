export const Pagination: React.FC<{currnetPage:number,
    totalPages: number,
    paginate: any}> = (props) => {
    
    const pageNumbers = [];
    if (props.currnetPage == 1) {
        pageNumbers.push(props.currnetPage);
        if (props.totalPages >= props.currnetPage + 1) {
            pageNumbers.push(props.currnetPage + 1);
        }
        if (props.totalPages >= props.currnetPage + 2) {
            pageNumbers.push(props.currnetPage + 2);
        }
    } else if (props.currnetPage > 1) {
        if ( props.currnetPage >=3 ) {
            pageNumbers.push(props.currnetPage - 2);
            pageNumbers.push(props.currnetPage - 1);
        } else {
            pageNumbers.push(props.currnetPage - 1)
        }

        pageNumbers.push(props.currnetPage);
        if (props.totalPages >= props.currnetPage + 1) {
            pageNumbers.push(props.currnetPage + 1);
        }
        if (props.totalPages >= props.currnetPage + 2) {
            pageNumbers.push(props.currnetPage + 2);
        }
    }
        
    return (
        <nav aria-label="...">
            <ul className='pagination'>
                <li className='page-item' onClick={() => props.paginate(1)}>
                    First Page
                </li>
                {pageNumbers.map(number => (
                    <li key={number} onClick={() => props.paginate(number)}
                        className={'page-item' + (props.currnetPage === number ? 'active' : '')}>
                            <button className='page-link'>
                                {number}
                            </button>
                    </li>
                ))}
                <li className='page-item' onClick={() => props.paginate(props.totalPages)}>
                    <button className='page-link'>
                        Last Page
                    </button>
                </li>
            </ul>
        </nav>
    )
}