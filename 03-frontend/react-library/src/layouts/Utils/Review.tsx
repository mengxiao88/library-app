import ReviewModel from "../../models/ReviewModel";
import { StartsReview } from "./StarsReview";

export const Review: React.FC<{ review: ReviewModel }> = (props) => {

    const date = new Date(props.review.date);
    const longMonth = date.toLocaleString('en-US', { month: 'long' });
    const day = date.getDate();
    const year = date.getFullYear();
    const dateRender = longMonth + ' ' + day + ', ' + year;

    return (
        <div>
            <div className='col-sm-8 col-md-8'>
                <h5>{props.review.userEmail}</h5>
                <div className='row'>
                    <div className='col'>
                        {dateRender}
                    </div>
                    <div className='col'>
                        <StartsReview rating={props.review.rating} size={16} />
                    </div>
                </div>
                <div className='mt-2'>
                    <p>
                        {props.review.reviewDescription ? props.review.reviewDescription : 'No review description.'}
                    </p>
                </div>
            </div>
        </div>
    );

}