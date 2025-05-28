package eu.york.u3rsfr3.motion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.motion.widget.MotionLayout;

import eu.york.u3rsfr3.R;

public class MotionMainActivity extends AppCompatActivity {

    private MotionLayout motionLayout;
    private Button callButton;
    private Button messageButton;
    private CardView profileCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_main);

        initializeViews();
        setupMotionLayout();
        setupClickListeners();
    }

    private void initializeViews() {
        // Initialize views using findViewById
        motionLayout = findViewById(R.id.motionLayout); // Add this ID to your MotionLayout
        callButton = findViewById(R.id.callButton);
        messageButton = findViewById(R.id.messageButton);
        profileCard = findViewById(R.id.profileCard);
    }

    private void setupMotionLayout() {
        // Listen to MotionLayout state changes
        motionLayout.setTransitionListener(new MotionLayout.TransitionListener() {
            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int startId, int endId) {
                // Animation started
            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int startId, int endId, float progress) {
                // Animation progress changed (0.0f to 1.0f)
                // You can use this for custom animations or UI updates

                // Example: Update alpha of elements based on progress
                // if (progress > 0.5f) {
                //     callButton.setAlpha(progress);
                //     messageButton.setAlpha(progress);
                // }
            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int currentId) {
                // Animation completed
                if (currentId == R.id.start) {
                    showToast("Profile collapsed");
                } else if (currentId == R.id.end) {
                    showToast("Profile expanded");
                }
            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int triggerId, boolean positive, float progress) {
                // Custom triggers (if defined in motion scene)
            }
        });
    }

    private void setupClickListeners() {
        // Handle button clicks
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Calling John Doe...");
                // Add actual phone call intent here
                // Intent intent = new Intent(Intent.ACTION_DIAL);
                // intent.setData(Uri.parse("tel:+15551234567"));
                // startActivity(intent);
            }
        });

        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Opening message app...");
                // Add actual messaging intent here
                // Intent intent = new Intent(Intent.ACTION_SENDTO);
                // intent.setData(Uri.parse("smsto:+15551234567"));
                // intent.putExtra("sms_body", "Hello John!");
                // startActivity(intent);
            }
        });

        // Optional: Click to toggle animation
        profileCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleProfileState();
            }
        });
    }

    private void toggleProfileState() {
        if (motionLayout.getCurrentState() == R.id.start) {
            // Expand the profile
            motionLayout.transitionToEnd();
        } else {
            // Collapse the profile
            motionLayout.transitionToStart();
        }
    }

    // Public methods for programmatic control (useful for testing)
    public void expandProfile() {
        motionLayout.transitionToEnd();
    }

    public void collapseProfile() {
        motionLayout.transitionToStart();
    }

    public boolean isProfileExpanded() {
        return motionLayout.getCurrentState() == R.id.end;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    // Handle back button to collapse if expanded
    @Override
    public void onBackPressed() {
        if (motionLayout.getCurrentState() == R.id.end) {
            motionLayout.transitionToStart();
        } else {
            super.onBackPressed();
        }
    }
}