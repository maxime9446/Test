export declare class BowlingScore {
    private readonly frames;
    constructor(frames: number[]);
    calculateTotalScore(): number;
    calculateTotalScoreWithSpare(): number;
    calculateTotalScoreWithStrike(): number;
    calculateTotalScoreWithSpareAndStrike(): number;
}
